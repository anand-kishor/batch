package com.batch.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan(basePackages= {"com.batch.demo"})
public class SpringBatchExample01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchExample01Application.class, args);
	}

}