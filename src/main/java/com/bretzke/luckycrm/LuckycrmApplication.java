package com.bretzke.luckycrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LuckycrmApplication {
	public static void main(String[] args) {
		SpringApplication.run(LuckycrmApplication.class, args);
	}
}
