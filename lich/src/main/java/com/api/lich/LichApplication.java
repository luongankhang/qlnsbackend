package com.api.lich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.api.lich")
public class LichApplication {

	public static void main(String[] args) {
		SpringApplication.run(LichApplication.class, args);
	}

}
