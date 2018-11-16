package com.example.developers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DevelopersRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopersRestApiApplication.class, args);
	}
}
