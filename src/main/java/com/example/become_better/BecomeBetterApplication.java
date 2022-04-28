package com.example.become_better;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BecomeBetterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BecomeBetterApplication.class, args);
    }

}
