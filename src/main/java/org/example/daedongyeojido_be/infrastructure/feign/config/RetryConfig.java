package org.example.daedongyeojido_be.infrastructure.feign.config;

import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.example.daedongyeojido_be.infrastructure.feign.Custom5xxRetryer;
import org.example.daedongyeojido_be.infrastructure.feign.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetryConfig {

    @Bean
    public Retryer retryer(){
        return new Custom5xxRetryer();
    }

    @Bean
    public ErrorDecoder errorDecoder(){
        return new CustomErrorDecoder();
    }
}
