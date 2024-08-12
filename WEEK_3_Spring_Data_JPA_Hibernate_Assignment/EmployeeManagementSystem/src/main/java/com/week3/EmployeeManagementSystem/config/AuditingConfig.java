package com.week3.EmployeeManagementSystem.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//AuditingConfig class and the annotations added as part of instructions in Excercise 7 
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        // Here you can provide the current user or system as the auditor.
        return () -> Optional.of("system"); 
    }
}