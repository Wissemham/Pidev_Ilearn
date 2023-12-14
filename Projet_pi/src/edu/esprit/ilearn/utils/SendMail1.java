
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author dell
 */
public class SendMail1 {
    public static void sendMail(String recepient,String r) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String myAccountEmail = "wissem.hammouda@esprit.tn";
        String password = "213JMT5489";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(myAccountEmail, password);
            }
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(myAccountEmail, password);
//            }
            
        });
        Message message = prepareMessage(session, myAccountEmail, recepient,r);
        Transport.send(message);
        System.out.println("Message sent successfully");
        }
        private static Message prepareMessage(Session session, String myAccountEmail, String recepient,String r) throws AddressException {
            
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("CONFIRMATION D'envoyer");
            message.setText(r);
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(SendMail1.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
}
    
}