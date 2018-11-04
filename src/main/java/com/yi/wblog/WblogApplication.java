package com.yi.wblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WblogApplication.class, args);
	}
}
