/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import javax.mail.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.PasswordAuthentication;
import java.util.Properties;

/**
 *
 * @author Ariana Llaguno
 */
public class Correo {
     private final static String remitente = "ventadevehiculo@gmail.com";
     private final static String contrasena= "Contra,1";
     
    public Correo(){
    }
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.clave","miClaveDeGmail");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getDefaultInstance(prop);
    MimeMessage message = new MimeMessage(session);

    try {
        message.setFrom(new InternetAddress(remitente));
        message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinatario)
            );   //Se podrían añadir varios de la misma manera
        message.setSubject(asunto);
        message.setText(mensaje);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", remitente, contrasena);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    catch (MessagingException me) {
        me.printStackTrace();   //Si se produce un error
    }
}
}