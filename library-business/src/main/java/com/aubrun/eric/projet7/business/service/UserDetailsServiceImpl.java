package com.aubrun.eric.projet7.business.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aubrun.eric.projet7.beans.UserAccount;
import com.aubrun.eric.projet7.consumer.repository.UserAccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountRepository userRepository;

    public UserDetailsServiceImpl(UserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount user = userRepository.findByNameUser(username);
                /*.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));*/

        return UserDetailsImpl.build(user);
    }
}
