package com.aubrun.eric.projet7.business.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);
}