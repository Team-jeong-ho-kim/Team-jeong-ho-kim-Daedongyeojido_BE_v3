package org.example.daedongyeojido_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DaedongyeojidoBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaedongyeojidoBeApplication.class, args);
    }

}
