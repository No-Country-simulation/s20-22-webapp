package com.eventix.eventix.security;

import com.eventix.eventix.service.jwt.IJwtUtilityService;
import com.eventix.eventix.service.auth.TokenBlacklistService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final IJwtUtilityService jwtUtilityService;
    private final TokenBlacklistService tokenBlacklistService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, TokenBlacklistService tokenBlacklistService) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors((CorsConfigurer::disable))
                .authorizeHttpRequests(authRequest ->
                        authRequest.requestMatchers("/auth/**", "/swagger-ui/**",
                                        "/swagger-ui.html").permitAll()
                                .anyRequest().authenticated())
                .sessionManagement(sessionManager ->
                        sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(new JWTAuthorizationFilter(jwtUtilityService, tokenBlacklistService),
                        UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}