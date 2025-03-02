package com.crizen.springboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SpringBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoardApplication.class, args);
    }

}
