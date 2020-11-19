package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountService accountService;

    public UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = accountService.findUserByUserName(username);
        if (userAccount == null) throw new UsernameNotFoundException(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        userAccount.getUserRoleList().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getUserRoleName())));
        return new User(userAccount.getNameUser(), userAccount.getMotDePasse(), authorities);
    }
}
