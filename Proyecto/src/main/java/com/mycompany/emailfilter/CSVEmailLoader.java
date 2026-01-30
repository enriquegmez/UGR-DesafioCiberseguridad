package com.mycompany.emailfilter;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Enrique Gómez
 * @author Pedro Gabriel Fernández
 */

/**
 * Clase para descargar las bases de datos de phishing y/o spam
 */
public class CSVEmailLoader {
    
    
    // Método para cargar los correos phishing desde el archivo CSV
    public static List<String> loadPhishingEmailsFromCSV(String fileName) throws IOException, CsvException {
        
        List<String> emails = new ArrayList<>();

        InputStream inputStream = CSVEmailLoader.class.getClassLoader().getResourceAsStream(fileName);
        
        // Verificamos si el archivo existe
        if (inputStream == null) {
            System.err.println("No se pudo encontrar el archivo: " + fileName);
            throw new IOException("El archivo " + fileName + " no se encuentra en el classpath.");
        }

        try (InputStreamReader isReader = new InputStreamReader(inputStream);
             CSVReader reader = new CSVReader(isReader)) {

            List<String[]> records = reader.readAll();  // Leer todas las filas del CSV

            // Iteramos sobre los registros del CSV
            for (String[] record : records) {
                if (record.length >= 2) {  // Verificar que haya al menos dos columnas
                    String emailDetection = record[1].trim(); // Columna 1 con la etiqueta (spam o ham)
                    String emailBody = record[0].trim(); // Columna 0 con el contenido del correo

                    // Si el correo es phishing o spam, lo agregamos a la lista
                    if ("1".equals(emailDetection) || "spam".equals(emailDetection)) {
                        emails.add(emailBody.toLowerCase());
                    }
                }
            }
        }

        // Si no se encuentran correos phishing, devolvemos una lista vacía
        return emails;
    }

}
