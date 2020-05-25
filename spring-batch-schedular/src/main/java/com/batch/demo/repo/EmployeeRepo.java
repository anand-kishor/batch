package com.batch.demo.repo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.batch.demo.model.Employee;
@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

}
