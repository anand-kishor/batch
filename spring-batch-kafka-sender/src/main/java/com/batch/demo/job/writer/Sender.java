package com.batch.demo.job.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.batch.demo.model.Employee;
@Service
public class Sender {
	@Autowired
	private KafkaTemplate<String,Employee> kafkaTemplate; 

	public void send(Employee employees) {
		// TODO Auto-generated method stub
		kafkaTemplate.send("EMPLOYEE", employees);
		
	}

}
