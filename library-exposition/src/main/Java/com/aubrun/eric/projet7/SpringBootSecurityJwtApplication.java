package com.aubrun.eric.projet7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication/*(exclude = { SecurityAutoConfiguration.class })*/
public class SpringBootSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
    }
}