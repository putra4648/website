package com.putra.portfolio.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppConfig {
  private final String[] ACCEPTED_URLS_NON_USER = new String[] {
      "/api/v1/register",
      "/api/v1/forgot-password",
      "/api/v1/download-cv"
  };

  private final String[] ACCEPTED_URLS_ANY_ROLE = new String[] {
      "/api/v1/portfolio",
      "/api/v1/contacts",
      "/api/v1/experience",
  };

  @Bean
  ModelMapper mapper() {
    return new ModelMapper();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
            auth -> auth
                .requestMatchers(ACCEPTED_URLS_NON_USER).permitAll()
                .requestMatchers(HttpMethod.GET, ACCEPTED_URLS_ANY_ROLE).hasRole("USER")
                .requestMatchers(ACCEPTED_URLS_ANY_ROLE).hasRole("SUPERADMIN")
                .anyRequest().authenticated())
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults());
    return http.build();
  }
}
