package com.aubrun.eric.projet7.controllers;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.business.service.AccountService;
import com.aubrun.eric.projet7.templates.RegisterForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    //Create
    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterForm registerForm){
        if(!registerForm.getPassword().equals(registerForm.getRepassword())) throw new RuntimeException("You must confirm your password");
        UserAccount user = accountService.findUserByUserName(registerForm.getUsername());
        if(user != null) throw new RuntimeException("This user already exists");
        UserAccount userAccount = new UserAccount();
        userAccount.setNameUser(registerForm.getUsername());
        userAccount.setMotDePasse(registerForm.getPassword());
        accountService.saveUser(userAccount);
        accountService.addRoleToUser(registerForm.getUsername(), "USER");
        return userAccount;
    }
}
