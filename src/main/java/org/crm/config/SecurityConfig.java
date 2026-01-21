package org.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    // without hashing password
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user = User.builder().username("admin").password("{noop}admin").build();
//        return new InMemoryUserDetailsManager(user);
//    }


    // Hashed Password
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user = User.builder().username("admin").password("{bcrypt}$2a$12$Iae/nzxwgDOoi2Zx6.xOhODqlNE.NRcKdlhymefAv8ZDvjeg.r5pi").build();
//        return new InMemoryUserDetailsManager(user);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user = User.builder().username("admin").password("$2a$12$voEbF5g3enfH2y.Eba.tTu3MAVRR6wK7z.79F7ktGGn40EOncBjMq").build();
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/add").authenticated()
                        .requestMatchers("/user/public").permitAll()
                        .requestMatchers("/employee/**").permitAll()
                        .anyRequest().authenticated()
                ).formLogin(Customizer.withDefaults()).logout(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults()); // ✅ FIXED

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
