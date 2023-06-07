//package com.example.newproject.mappers;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers(HttpMethod.DELETE, "/api/jobs/**").permitAll()
//                // Add other security rules if needed
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                // Configure form login if needed
//                .and()
//                .csrf().disable();
//    }
//}