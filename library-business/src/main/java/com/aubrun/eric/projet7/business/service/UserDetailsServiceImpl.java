package com.aubrun.eric.projet7.business.service;

import com.aubrun.eric.projet7.business.dto.UserAccountDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountService userAccountService;

    public UserDetailsServiceImpl(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccountDto userAccountDto = userAccountService.obtainByNameUser(username);
        if(userAccountDto == null) throw new UsernameNotFoundException(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        userAccountDto.getUserRoleDtoList().forEach(r-> authorities.add(new SimpleGrantedAuthority(r.getUserRoleName())));
        return new User(userAccountDto.getNameUser(), userAccountDto.getMotDePasse(), authorities);
    }
}
