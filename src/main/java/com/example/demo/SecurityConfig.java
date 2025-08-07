package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Bean
//    @Order(0)
//    public SecurityFilterChain h2ConsoleSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .securityMatcher("/h2-console/**")
//                .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll())
//                .csrf(csrf -> csrf.disable()) // важно!
//                .headers(headers -> headers.frameOptions().disable()); // важно!
//
//        return http.build(); // последний пункт (Order5) надо тоже закометнтить иначе не даст залогинится в /h2-console
//    }


    @Bean
    @Order(1)
    public SecurityFilterChain registrationFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.securityMatcher("/security/registration").
                authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).
                csrf(csrf->csrf.disable()).build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain userSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.securityMatcher("/security/user/**")
                .authorizeHttpRequests(a -> a.anyRequest().hasAnyRole("USER", "ADMIN"))
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    @Order(3)
    public SecurityFilterChain adminSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.securityMatcher("/security/admin/**")
                .authorizeHttpRequests(a -> a.anyRequest().hasRole("ADMIN"))
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    @Order(4)
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.securityMatcher("/security/**")
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    @Order(5)
    public SecurityFilterChain studentsSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).formLogin(Customizer.withDefaults()).build();
    }

}
