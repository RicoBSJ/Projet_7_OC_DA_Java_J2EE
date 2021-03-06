package com.aubrun.eric.projet7.business.service;

public interface EmailService {

    default void sendSimpleMessage(String to, String subject, String text){

    }
}
