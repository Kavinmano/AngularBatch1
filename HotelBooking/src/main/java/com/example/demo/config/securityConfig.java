package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class securityConfig {

    // Define users and roles
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("kavin")
                .password("kavin123")
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("aarthi")
                .password("aarthi123")
                .roles("CUSTOMER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    // Define authorization rules
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .httpBasic()
            .and()
            .authorizeHttpRequests()
                .requestMatchers("/addHotel", "/deleteHotel/**").hasRole("ADMIN")
                .requestMatchers("/viewHotels", "/searchById/**").hasAnyRole("ADMIN", "CUSTOMER")
                .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .csrf().disable();

        return http.build();
    }

    // No password encoding (for demo purposes only)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
