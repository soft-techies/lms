package com.lms.userlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.lms.userlogin.repository")
@EntityScan(basePackages = "com.lms.userlogin.model")
public class UserloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserloginApplication.class, args);
	}

	
}
