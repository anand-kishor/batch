package com.batch.demo.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.batch.demo.repo.EmployeeRepo;

public class EmployeeCleanup implements Tasklet {
	@Autowired
	private EmployeeRepo employeeRepo;
	

	public EmployeeCleanup(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}


	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		employeeRepo.deleteAll();
		return RepeatStatus.FINISHED;
	}

}