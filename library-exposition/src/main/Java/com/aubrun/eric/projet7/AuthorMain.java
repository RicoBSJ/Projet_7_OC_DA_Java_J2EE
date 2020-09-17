package com.aubrun.eric.projet7;

import com.aubrun.eric.projet7.beans.Author;
import com.aubrun.eric.projet7.consumer.repository.AuthorRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

public class AuthorMain implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthorRepository authorRepository;

    public static void main(String[] args){
        SpringApplication.run(AuthorMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Book id 10001 -> {}", authorRepository.findById(1));

        logger.info("All users 1 -> {}", authorRepository.findAll());

        //Insert
        logger.info("Inserting -> {}", authorRepository.save(new Author("John", "Galloway")));

        //Update
        logger.info("Update 10001 -> {}", authorRepository.save(new Author("Gaby", "Name-Updated")));

        authorRepository.deleteById(1);

        logger.info("All users 2 -> {}", authorRepository.findAll());
    }
}
