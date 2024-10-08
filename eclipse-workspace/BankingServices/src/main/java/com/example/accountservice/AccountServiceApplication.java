package com.example.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Account Service Application.
 * This class bootstraps the Spring Boot application.
 */
@SpringBootApplication // Indicates that this is a Spring Boot application
public class AccountServiceApplication {

    /**
     * The main method that serves as the entry point for the Spring Boot application.
     * It uses Spring Boot's SpringApplication.run() method to launch the application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        // Run the application
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}
