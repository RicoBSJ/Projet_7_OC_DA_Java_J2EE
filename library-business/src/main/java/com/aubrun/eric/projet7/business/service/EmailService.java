package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.MailObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    public EmailService(@Qualifier("getJavaMailSender") JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(MailObject mailObject) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreply@baeldung.com");
            message.setTo(mailObject.getTo());
            message.setSubject(mailObject.getSubject());
            message.setText(mailObject.getText());
            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }
}