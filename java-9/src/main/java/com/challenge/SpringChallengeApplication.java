package com.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class SpringChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringChallengeApplication.class, args);
	}
}
