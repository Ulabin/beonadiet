package com.ds.mainpagetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MainpagetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainpagetestApplication.class, args);
	}

}
