package com.ardaklc.SpringSecuritySix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin();
        http.userDetailsService(userDetailsService);
        http
                .authorizeHttpRequests(
                        auth ->
                                auth.requestMatchers("/admin/**").hasRole("ADMIN")
                                        .requestMatchers("/dashboard/**").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/index").permitAll()
                                        .anyRequest().authenticated()
                );
        return http.build();
    }
}