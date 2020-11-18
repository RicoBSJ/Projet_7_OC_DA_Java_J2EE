package com.aubrun.eric.projet7;

import com.aubrun.eric.projet7.beans.Task;
import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import com.aubrun.eric.projet7.business.service.AccountService;
import com.aubrun.eric.projet7.business.service.UserAccountService;
import com.aubrun.eric.projet7.business.service.UserRoleService;
import com.aubrun.eric.projet7.consumer.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication/*(exclude = { SecurityAutoConfiguration.class })*/
public class Main implements CommandLineRunner {

    private final TaskRepository taskRepository;
    private final UserAccountService userAccountService;
    private final UserRoleService userRoleService;
    private final AccountService accountService;

    public Main(TaskRepository taskRepository, @Lazy UserAccountService userAccountService, UserRoleService userRoleService, AccountService accountService) {
        this.taskRepository = taskRepository;
        this.userAccountService = userAccountService;
        this.userRoleService = userRoleService;
        this.accountService = accountService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            UserAccountDto userAccountDto = userAccountService.findByUserName(username);
            if (userAccountDto == null) throw new UsernameNotFoundException(username);
            List<GrantedAuthority> authorities = new ArrayList<>();
            userAccountDto.getUserRoleDtoList().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getUserRoleName())));
            return new User(userAccountDto.getNameUser(), userAccountDto.getMotDePasse(), authorities);
        };
    }

    @Override
    public void run(String... args) {
        accountService.saveUser(new UserAccountDto());

        Stream.of("T1", "T2", "T3").forEach(t -> {
            taskRepository.save(new Task(null, t));
        });
        taskRepository.findAll().forEach(t -> {
            System.out.println(t.getTaskName());
        });
    }
}