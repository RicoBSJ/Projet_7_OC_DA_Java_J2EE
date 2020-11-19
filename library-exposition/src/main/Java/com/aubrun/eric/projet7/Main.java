package com.aubrun.eric.projet7;

import com.aubrun.eric.projet7.beans.Task;
import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.beans.UserRole;
import com.aubrun.eric.projet7.business.service.AccountService;
import com.aubrun.eric.projet7.consumer.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication/*(exclude = { SecurityAutoConfiguration.class })*/
public class Main implements CommandLineRunner {

    private final TaskRepository taskRepository;
    private final AccountService accountService;

    public Main(TaskRepository taskRepository, @Lazy AccountService accountService) {
        this.taskRepository = taskRepository;
        this.accountService = accountService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) {
        accountService.saveUser(new UserAccount(null, "admin", "1234", null));
        accountService.saveUser(new UserAccount(null, "user", "1234", null));
        accountService.saveRole(new UserRole(null, "ADMIN"));
        accountService.saveRole(new UserRole(null, "USER"));
        accountService.addRoleToUser("admin", "ADMIN");
        accountService.addRoleToUser("admin", "USER");
        accountService.addRoleToUser("user", "USER");

        Stream.of("T1", "T2", "T3").forEach(t -> {
            taskRepository.save(new Task(null, t));
        });
        taskRepository.findAll().forEach(t -> {
            System.out.println(t.getTaskName());
        });
    }
}