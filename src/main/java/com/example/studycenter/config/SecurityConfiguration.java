package com.example.studycenter.config;

import com.example.studycenter.security.JwtConfigurer;
import com.example.studycenter.security.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfiguration(@Lazy UserDetailsService userDetailsService, JwtTokenProvider jwtTokenProvider) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/api/group/*").hasRole("ADMIN")
                .antMatchers("/api/timeTable/*").hasRole("ADMIN")
                .antMatchers("/api/timeTableUser/*").hasRole("ADMIN")
                .antMatchers("/api/timeTableUserData/*").hasRole("ADMIN")
                .antMatchers("/api/group").hasRole("USER")
                .antMatchers("/api/timeTable").hasRole("USER")
                .antMatchers("/api/timeTableUser").hasRole("USER")
                .antMatchers("/api/timeTableUserData").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));

    }

}