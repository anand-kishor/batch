package com.batch.consumer.service;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.batch.consumer.model.Employee;

@Component
public class ReceiverKafkaMessage {
	private CountDownLatch latch=new CountDownLatch(1);
	@KafkaListener(topics="EMPLOYEE")
    public void receive(Employee emp)
    {
		System.out.println("receive employee details ={}"+emp.toString());
		latch.countDown();
    }
}
