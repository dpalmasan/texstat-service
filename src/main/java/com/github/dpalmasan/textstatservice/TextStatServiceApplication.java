package com.github.dpalmasan.textstatservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.dpalmasan.metrics")
public class TextStatServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextStatServiceApplication.class, args);
    }

}
