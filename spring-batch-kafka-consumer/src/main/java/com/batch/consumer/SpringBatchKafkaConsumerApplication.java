package com.batch.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.batch.consumer"})
public class SpringBatchKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchKafkaConsumerApplication.class, args);
	}

}
