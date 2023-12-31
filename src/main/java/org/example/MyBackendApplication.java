package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBackendApplication.class, args);
    }
}