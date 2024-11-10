package com.interview;

// src/Main.java


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages="com.interview")
@EntityScan
@EnableJpaRepositories
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(com.interview.Main.class, args);
    }

}
