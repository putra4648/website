package com.putra.portfolio.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfiguration {

    private final String[] ACCEPTED_URLS = new String[] {
            "/",
            "/portfolio",
            "/work",
            "/webjars/**"
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
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("USER").build());
        return manager;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers(ACCEPTED_URLS).permitAll()
                                .anyRequest().authenticated())
                .userDetailsService(userDetailsService())
                .formLogin(login -> {
                    login.loginPage("/login");
                })
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

}
