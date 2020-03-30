package com.galvanize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class FastFoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastFoodApplication.class, args);
    }

}
