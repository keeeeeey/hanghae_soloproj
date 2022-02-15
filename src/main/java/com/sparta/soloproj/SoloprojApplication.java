package com.sparta.soloproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SoloprojApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoloprojApplication.class, args);
    }

}
