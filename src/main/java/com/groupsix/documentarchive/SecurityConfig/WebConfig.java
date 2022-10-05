package com.groupsix.documentarchive.SecurityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/register").setViewName("AutoRedirect");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/register").setViewName("registrationForm");
        registry.addViewController("/login").setViewName("Login");
    }
}
