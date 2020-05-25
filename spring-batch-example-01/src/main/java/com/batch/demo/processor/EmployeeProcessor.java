package com.batch.demo.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.batch.demo.model.Employee;
@Component
public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		emp.setId(item.getId());
		emp.setName(item.getName());
		emp.setEmail(item.getEmail());
		emp.setAddress(item.getAddress());
		emp.setAge(item.getAge());
		String s1=emp.getName().toUpperCase();
		String s2=emp.getEmail().toLowerCase();
		String s3=emp.getAddress().toUpperCase();
		System.out.println("name:"+s1+"email:"+s2+"address :"+s3);
		return emp;
	}

}
