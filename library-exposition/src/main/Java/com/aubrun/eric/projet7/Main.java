package com.aubrun.eric.projet7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication/*(exclude = { SecurityAutoConfiguration.class })*/
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}