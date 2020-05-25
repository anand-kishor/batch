package com.batch.demo.job.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.batch.demo.model.Employee;

public class KafkaSenderWriter implements ItemWriter<Employee> {
	@Autowired
	private Sender sender;

	@Override
	public void write(List<? extends Employee> items) throws Exception {
		// TODO Auto-generated method stub
		for(Employee employees:items)
		{
			sender.send(employees);
		}
		System.out.println("message send to kafka");
		
	}

}
