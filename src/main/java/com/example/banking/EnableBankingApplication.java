package com.example.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EnableBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnableBankingApplication.class, args);
	}

	@Bean
	public Runner getRunner() {
		return new Runner();
	}
}
