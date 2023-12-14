/*
<<<<<<< HEAD
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
=======
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
>>>>>>> 630c771093ec8cf466c8582a75b1c6e3c3ceb7f0
 */
package edu.esprit.ilearn.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
<<<<<<< HEAD
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
=======
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
>>>>>>> 630c771093ec8cf466c8582a75b1c6e3c3ceb7f0
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
<<<<<<< HEAD
 * @author MSI
 */
public class SendMail {
    public static void sendMail(String recepient) throws Exception {
=======
 * @author ASUS
 */
public class SendMail {

    public static void sendMail(String recepient , String e) throws Exception {
>>>>>>> 630c771093ec8cf466c8582a75b1c6e3c3ceb7f0
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
<<<<<<< HEAD
        String myAccountEmail = "";
        String password = "";
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
        Message message = prepareMessage(session, myAccountEmail, recepient);
        Transport.send(message);
        System.out.println("Message sent successfully");
        }
        private static Message prepareMessage(Session session, String myAccountEmail, String recepient) throws AddressException {
            
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("CONFIRMATION D'INSCRIPTION");
            message.setText("Merci de votre inscription !, \n Félicitations !Vous êtes désormais inscrit à ILEARN");
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
}
    
}
=======
        String myAccountEmail = "aladin.hammouda@esprit.tn";
        String password = "213JMT6795";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessage(session, myAccountEmail, recepient,e);
        Transport.send(message);
        System.out.println("Message sent successfully");
    }
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient,String e) {
try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Mon premier e-mail depuis l'application Java");
            message.setText("Bonjour, \n Votre commande est "+e+"");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
>>>>>>> 630c771093ec8cf466c8582a75b1c6e3c3ceb7f0
