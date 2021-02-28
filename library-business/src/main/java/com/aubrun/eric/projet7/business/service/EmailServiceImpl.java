package com.aubrun.eric.projet7.business.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    public EmailServiceImpl(@Qualifier("getJavaMailSender") JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(
            String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("s_jobs@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}