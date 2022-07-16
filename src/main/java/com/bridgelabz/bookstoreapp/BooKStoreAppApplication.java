package com.bridgelabz.bookstoreapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BooKStoreAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooKStoreAppApplication.class, args);
    }

}          
