package com.batch.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@ComponentScan(basePackages= {"com.batch.demo"})
public class SpringBatchSchedularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchSchedularApplication.class, args);
	}

}
