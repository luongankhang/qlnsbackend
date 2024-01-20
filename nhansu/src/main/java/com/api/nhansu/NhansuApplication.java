package com.api.nhansu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.api.nhansu")
public class NhansuApplication {

    public static void main(String[] args) {
        SpringApplication.run(NhansuApplication.class, args);
    }

}
