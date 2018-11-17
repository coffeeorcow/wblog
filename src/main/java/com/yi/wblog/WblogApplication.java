package com.yi.wblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("com.yi.wblog.repository")
@EnableTransactionManagement
@EnableJpaAuditing
public class WblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WblogApplication.class, args);
	}
}
