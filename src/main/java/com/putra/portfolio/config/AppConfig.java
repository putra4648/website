package com.putra.portfolio.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

    private final String[] ACCEPTED_URLS = new String[] {
            "/",
            "/projects",
            "/experience",
            "/download-cv",
            "/denied",
            "/webjars/**",
            "/js/**",
    };

    @Bean
    AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthEntryPointConfig();
    }

    @Bean
    ModelMapper mapper() {
        return new ModelMapper();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("USER").build());
        return manager;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers(headers -> {
                    headers.frameOptions(options -> options.sameOrigin());
                })
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers(ACCEPTED_URLS).permitAll()
                                .anyRequest().authenticated())
                .userDetailsService(userDetailsService())
                .formLogin(login -> login.disable())
                .httpBasic(basic -> basic.authenticationEntryPoint(authenticationEntryPoint()));
        return http.build();
    }

}
