package com.api.taikhoan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "api.com.taikhoan")
public class TaikhoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaikhoanApplication.class, args);
	}

}
