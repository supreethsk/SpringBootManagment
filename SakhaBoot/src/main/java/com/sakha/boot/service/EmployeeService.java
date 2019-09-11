package com.sakha.boot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.websocket.SendResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sakha.boot.model.Employee;
import com.sakha.boot.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;

	public Employee save(Employee emp) {
		emp.setId(generateId(emp.getEmpName()));
		return repo.save(emp);

	}

	public Employee getEmployee(int empId) {
		return repo.getOne(empId);
	}

	public List<Employee> getAllEmplpoyee() {
		return repo.findAll();
	}

	public boolean deleteEmployee(int empId) {
		repo.deleteById(empId);
		return true;
	}

	public boolean validate(Employee emp) {
		if (emp.getEmpName().length() < 4 || emp.getEmpName().length() > 15) {
			return false;
		} else if (emp.getDob().isAfter(LocalDate.of(2000, 12, 31))
				|| emp.getDob().isBefore(LocalDate.of(1900, 1, 1))) {
			return false;
		} else if (emp.getSalary() < 20000f || emp.getSalary() > 80000f) {
			return false;
		} else {
			return true;
		}
	}

	public String generateId(String empName) {
		// TODO Auto-generated method stub
		String nameChar = empName.substring(0, 2).toUpperCase();
		Random rand = new Random();
		int dgt = (int) (rand.nextDouble() * 10000);
		return nameChar + dgt;

	}

	public Employee updateEmployee(Employee emp) {
		Employee emp1 = repo.getEmployeeById(emp.getEmpId());
		emp1.setEmpName(emp.getEmpName());
		emp1.setAge(emp.getAge());
		emp1.setDob(emp.getDob());
		emp1.setSalary(emp.getSalary());
		// repo.getEmployeeById(empId);
		return repo.save(emp1);

	}
}
