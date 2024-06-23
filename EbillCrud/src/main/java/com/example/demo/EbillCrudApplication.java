package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
	    "com.example.demo.controller",    // Package containing your controllers
	    "com.example.demo.service",       // Package containing your services
	    "com.example.demo.dao"            // Package containing your repositories (if in a different package)
	    // Add more packages as needed
	})
public class EbillCrudApplication {
	public static void main(String[] args) {
		SpringApplication.run(EbillCrudApplication.class, args);
	}

}
