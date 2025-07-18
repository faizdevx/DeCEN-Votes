package com.votechain.votechain_india;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(a -> a
                .requestMatchers("/css/**","/login").permitAll()
                .anyRequest().authenticated())
            .formLogin(f -> f.loginPage("/login").permitAll())
            .logout(l -> l.logoutSuccessUrl("/login?logout"))
            .csrf().disable();                 // for demo only
        return http.build();
    }

    @Bean
    public PasswordEncoder encoder(){ return new BCryptPasswordEncoder();}

    @Bean
    public UserDetailsService users(PasswordEncoder enc){
        return new InMemoryUserDetailsManager(
            User.withUsername("alice").password(enc.encode("alice")).roles("USER").build(),
            User.withUsername("bob").password(enc.encode("bob")).roles("USER").build(),
            User.withUsername("charlie").password(enc.encode("charlie")).roles("USER").build()
        );
    }
}
