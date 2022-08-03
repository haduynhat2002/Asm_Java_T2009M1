package com.example.asm_t2009m1.config;

import com.example.asm_t2009m1.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    final AccountService accountService;
    final PasswordEncoder passwordEncoder;

    public MySecurityConfig(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        MyAuthenticationFilter authenticationFilter = new MyAuthenticationFilter(authenticationManagerBean());
        authenticationFilter.setFilterProcessesUrl("/api/v1/account/login");
        http.cors().and().csrf().disable();
        http.authorizeHttpRequests().antMatchers("/api/v1/hello","/api/v1/account/*").permitAll();
        http.authorizeHttpRequests().antMatchers("/api/v1/user").hasAnyAuthority("USER");
        http.authorizeHttpRequests().antMatchers("/api/v1/admin").hasAnyAuthority("ADMIN");
        http.addFilter(authenticationFilter);
    }
}
