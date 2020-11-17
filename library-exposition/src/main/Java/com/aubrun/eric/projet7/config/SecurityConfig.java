/*
package com.aubrun.eric.projet7.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "USER");
        auth.inMemoryAuthentication().withUser("Musk").password("eM86").roles("USER");
        auth.inMemoryAuthentication().withUser("Jobs").password("sJ53").roles("USER");
        auth.inMemoryAuthentication().withUser("Ma").password("jM68").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeRequests().anyRequest();
    }
}
*/
