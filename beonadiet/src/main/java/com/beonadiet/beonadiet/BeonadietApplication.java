package com.beonadiet.beonadiet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BeonadietApplication {
	public static void main(String[] args) {
		SpringApplication.run(BeonadietApplication.class, args);
	}

}
