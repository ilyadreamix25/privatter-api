package com.privatter.api.email;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Properties;

@Service
public class EmailService {
    @Autowired
    private EmailConfiguration configuration;

    /**
     * Send an email message in HTML format.
     * @param from the sender of this message
     * @param recipients the recipients of this message
     * @param body the body of this message
     * @param subject the subject of this message
     */
    public void sendHtmlMessage(
        InternetAddress from,
        InternetAddress[] recipients,
        String body,
        String subject
    ) {
        try {
            var properties = new Properties();

            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

            var session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(configuration.getUsername(), configuration.getPassword());
                }
            });

            var message = new MimeMessage(session);

            message.addHeader("Content-Type", "text/html; charset=utf-8");
            message.addHeader("Format", "flowed");
            message.addHeader("Content-Transfer-Encoding", "8bit");

            message.setFrom(from);
            message.setRecipients(Message.RecipientType.TO, recipients);
            message.setRecipients(Message.RecipientType.CC, recipients);
            message.setText(body, "UTF-8");
            message.setSubject(subject);

            var smtpTransport = session.getTransport("smtp");

            smtpTransport.connect();
            smtpTransport.sendMessage(message, message.getAllRecipients());
            smtpTransport.close();
        } catch (Exception exception) {
            LoggerFactory
                .getLogger(EmailService.class)
                .error("Cannot send email to " + Arrays.toString(recipients), exception);
        }
    }

    /**
     * Send an email message in HTML format.
     * @param from the sender of this message
     * @param recipient the recipient of this message
     * @param body the body of this message
     * @param subject the subject of this message
     */
    public void sendHtmlMessage(
        String from,
        String recipient,
        String body,
        String subject
    ) {
        try {
            sendHtmlMessage(
                new InternetAddress(from),
                new InternetAddress[] { new InternetAddress(recipient) },
                body, subject
            );
        } catch (Exception exception) {
            LoggerFactory
                .getLogger(EmailService.class)
                .error("Cannot send email to " + recipient, exception);
        }
    }
}
