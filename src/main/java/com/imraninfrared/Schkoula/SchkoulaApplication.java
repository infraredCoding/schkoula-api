package com.imraninfrared.Schkoula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SchkoulaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchkoulaApplication.class, args);
	}

}
