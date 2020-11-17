package com.aubrun.eric.projet7;

import com.aubrun.eric.projet7.beans.Task;
import com.aubrun.eric.projet7.consumer.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.stream.Stream;

@SpringBootApplication/*(exclude = { SecurityAutoConfiguration.class })*/
public class Main implements CommandLineRunner {

    private TaskRepository taskRepository;

    public Main(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("T1", "T2", "T3").forEach(t->{
            taskRepository.save(new Task(null, t));
        });
        taskRepository.findAll().forEach(t->{
            System.out.println(t.getTaskName());
        });
    }
}