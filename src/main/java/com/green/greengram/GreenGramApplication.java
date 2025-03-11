package com.green.greengram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableFeignClients
@ConfigurationPropertiesScan
@SpringBootApplication
public class GreenGramApplication {
    public static void main(String[] args) {
        SpringApplication.run(GreenGramApplication.class, args);
    }
}
