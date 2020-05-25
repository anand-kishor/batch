package com.batch.demo.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.batch.demo.model.Employee;

public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {

	@Override
	public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		emp.setId(fieldSet.readInt("id"));
		emp.setName(fieldSet.readString("name"));
		emp.setEmail(fieldSet.readString("email"));
		emp.setAddress(fieldSet.readString("address"));
		emp.setAge(fieldSet.readInt("age"));
		System.out.println(emp.toString());
		return emp;
	}

}
