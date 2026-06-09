package com.hospitalManagement.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig{
    private final PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/authenticate").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/doctors/**").hasAnyRole("DOCTOR", "ADMIN")
                        .anyRequest().authenticated()
                );

        return httpSecurity.build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails u1= User.withUsername("vamsi")
                .password(passwordEncoder.encode("vamsi"))
                .roles("ADMIN","DOCTOR")
                .build();
        UserDetails u2= User.withUsername("anirudh")
                .password("{noop}anirudh")
                .roles("PATIENT")
                .build();
        return new InMemoryUserDetailsManager(u1,u2);
    }
}
