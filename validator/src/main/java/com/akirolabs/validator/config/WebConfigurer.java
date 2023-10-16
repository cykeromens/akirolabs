package com.akirolabs.validator.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfigurer {
    @Value("${application.cors.allowed-path}")
    private String allowedPath;

    @Value("${application.cors.allowed-origin-patterns}")
    private String allowedOrigin;
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(allowedPath).allowedOrigins(allowedOrigin);
            }
        };
    }

}
