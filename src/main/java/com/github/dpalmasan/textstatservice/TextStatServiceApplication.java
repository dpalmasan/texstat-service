package com.github.dpalmasan.textstatservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.github.dpalmasan")
public class TextStatServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextStatServiceApplication.class, args);
    }

}
