package com.mycompany.emailfilter;

import com.opencsv.exceptions.CsvException;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


/**
 * @author Enrique Gómez
 * @author Pedro Gabriel Fernández
 */

/**
 * En esta clase se descarga cada correo de la carpeta y se realiza su clasificación.
 */
public class EmailSave {

    public static List<Email> parseEmailsFromFolder(String folderPath) {
        List<Email> emails = new ArrayList<>();
        File folder = new File(folderPath);

        for (File file : folder.listFiles((dir, name) -> name.endsWith(".eml"))) {
            try {
                Properties props = new Properties();
                Session session = Session.getDefaultInstance(props, null);
                MimeMessage message = new MimeMessage(session, new FileInputStream(file));

                String subject = message.getSubject();
                String from = Arrays.toString(message.getFrom());
                String content = showContent(message);
                String category = classifyEmail(subject, readAsText(file.getAbsolutePath()));
                Date date = message.getSentDate();

                emails.add(new Email(subject, from, content, category, date));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return emails;
    }
    
    
    public static String readAsText(String filePath) throws Exception {
        return Files.readString(Paths.get(filePath));
    }
    
    
    public static String showContent(MimeMessage message) throws MessagingException, IOException {
        StringBuilder result = new StringBuilder();

        // Verificamos si el mensaje es multipart
        if (message.isMimeType("multipart/*")) {
            return "";
        } else {
            // Si no es multipart, verificamos si el contenido es HTML
            String contentType = message.getContentType();
            if (contentType.contains("html")) {
                // Si es HTML, no mostramos nada
                return "";  // O puedes devolver null si prefieres que sea nulo
            } else {
                // Si es texto plano, extraemos el contenido
                result.append(message.getContent().toString());
            }
        }

        return result.toString();
    }

    // Clasificación heurística básica
    private static String classifyEmail(String subject, String content) throws IOException, CsvException {
        String lower = (subject + " " + content).toLowerCase();
        List<String> phishingEmails = CSVEmailLoader.loadPhishingEmailsFromCSV("phishing.csv");
        List<String> phishingKeys = PhishingDetector.phishingKeywords();
        List<String> spamEmails1 = CSVEmailLoader.loadPhishingEmailsFromCSV("spam1.csv");
        List<String> spamEmails2 = CSVEmailLoader.loadPhishingEmailsFromCSV("spam2.csv");
        List<String> spamKeys = SpamDetector.spamKeywords();

        for (int i = 0; i < spamEmails1.size(); i++) {
            if (lower.contains(spamEmails1.get(i))) {
                return "Spam";
            }
        }

        for (int i = 0; i < spamEmails2.size(); i++) {
            if (lower.contains(spamEmails2.get(i))) {
                return "Spam";
            }
        }

        for (int i = 0; i < spamKeys.size(); i++) {
            if (lower.contains(spamKeys.get(i))) {
                return "Spam";
            }
        }

        for (int i = 0; i < phishingEmails.size(); i++) {
            if (lower.contains(phishingEmails.get(i))) {
                return "Phishing";
            }

        }

        for (int i = 0; i < phishingKeys.size(); i++) {
            if (lower.contains(phishingKeys.get(i))) {
                return "Phishing";
            }
        }

        return "Inbox";
    }
}
