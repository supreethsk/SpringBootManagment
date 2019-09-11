package com.sakha.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakha.boot.model.Employee;
import com.sakha.boot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	EmployeeService es;

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() throws Exception {
		return es.getAllEmplpoyee();
	}

	@GetMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable("empId") int empId) throws Exception {
		return es.getEmployee(empId);
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee emp) throws Exception {
		return es.save(emp);
	}

	@DeleteMapping("/employees/{empId}")
	public boolean delete(@PathVariable("empId") int empId) throws Exception {
		return es.deleteEmployee(empId);
	}

	@PutMapping("/employees")
	public Employee update(@RequestBody Employee emp) throws Exception {
		return es.updateEmployee(emp);
	}

}
