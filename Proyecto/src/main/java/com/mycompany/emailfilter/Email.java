package com.mycompany.emailfilter;

import java.util.Date;

/**
 * @author Enrique Gómez
 * @author Pedro Gabriel Fernández
 */

/**
 * Clase para definir los campos de un objeto Email. 
 * En estos objetos guardaremos el contenido de los correos.
 */
public class Email {

    private String subject;
    private String from;
    private String content;
    private String category; // "Inbox", "Spam", "Phishing"
    private Date date;

    public Email(String subject, String from, String content, String category, Date date) {
        this.subject = subject;
        this.from = from;
        this.content = content;
        this.category = category;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public String getFrom() {
        return from;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public Date getDate() {
        return date;
    }
}
