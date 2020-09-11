package com.aubrun.eric.projet7.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello-2")
    public String index2() {
        return "Greetings from Spring Boot 2!";
    }
}
