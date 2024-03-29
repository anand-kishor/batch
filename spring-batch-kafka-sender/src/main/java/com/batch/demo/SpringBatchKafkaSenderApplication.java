package com.batch.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableBatchProcessing
@EnableKafka
@ComponentScan(basePackages= {"com.batch.demo"})
public class SpringBatchKafkaSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchKafkaSenderApplication.class, args);
	}

}
