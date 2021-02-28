package com.aubrun.eric.projet7.business.service;

public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);
}