package main;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
    private Mail mail;
    private String host;
    private Properties properties;
    private Session session;

    public SendMail(Mail mail, String host) {
        this.mail = mail;
        this.host = host;
        setProperties();
        setSession();
    }

    public SendMail(Mail mail) {
        this.mail = mail;
        this.host = "smtp.gmail.com";
        setProperties();
        setSession();
    }

    public void send() {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail.getAccount().getEmail()));
            message.addRecipients(Message.RecipientType.TO, getAllReciever());
            message.setSubject(mail.getSubject());
            message.setText(mail.getContent());

            Transport.send(message);
        } catch (AddressException addressException) {
            addressException.printStackTrace();
        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
        }
    }



    private void setProperties() {
        this.properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465"); // TCP: 587
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    }

    private void setSession() {
        this.session = Session.getInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mail.getAccount().getEmail(), mail.getAccount().getPassword());
            }
        });
    }

    private InternetAddress[] getAllReciever() {
        InternetAddress[] internetAddresses = new InternetAddress[mail.getReceiver().length];
        try {
            int i = 0;
            for (String s : mail.getReceiver()) {
                internetAddresses[i] = new InternetAddress(s);
                i++;
            }
        } catch (AddressException addressException) {
            addressException.printStackTrace();
        }

        return internetAddresses;
    }
}











