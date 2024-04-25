package com.example.supplycraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.supplycraft", "com.example.supplycraft.config"})
public class SupplyCraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplyCraftApplication.class, args);
	}

}
