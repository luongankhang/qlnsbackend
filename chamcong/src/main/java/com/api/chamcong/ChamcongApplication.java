package com.api.chamcong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.api.chamcong")
public class ChamcongApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChamcongApplication.class, args);
	}

}
