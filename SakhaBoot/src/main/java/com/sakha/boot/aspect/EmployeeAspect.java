package com.sakha.boot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {

	@Before("execution(* com.sakha.boot.service.EmployeeService.deleteEmployee(*))")
	public void showDeleteLog() {
		System.out.println("Deleting.....");
	}
}
