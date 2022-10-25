package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NonBlockingApplication {

  public static void main(String[] args) {
    SpringApplication.run(NonBlockingApplication.class, args);
  }


  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
