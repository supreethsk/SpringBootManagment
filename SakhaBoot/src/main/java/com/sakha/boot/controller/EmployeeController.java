package com.sakha.boot.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sakha.boot.model.Employee;
import com.sakha.boot.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@PostMapping("/employee")
	public String registerEmployee(@ModelAttribute Employee emp, Model m) {
		// Employee savedEmp=new Employee();
		if (service.validate(emp)) {
			service.save(emp);
			m.addAttribute("emp", emp);
			return "view";
		} else {
			return "view1";
		}
	}

	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("empId") int empId, Model m) {
		String msg = "Failed...";
		// Employee deleteEmp=service.getEmployee(empId);
		if (service.deleteEmployee(empId)) {
			msg = "Delete operation is Successfull..";
		}
		m.addAttribute("msg", msg);
		return "deleteview";
	}

	@GetMapping("/employees")
	public String getAllEmployee(Model m) {
		List<Employee> empList = service.getAllEmplpoyee();
		m.addAttribute("empList", empList);
		return "viewallemp";
	}

	@GetMapping("/getemployee")
	public String getEmployee(@RequestParam("id") int empId, Model m) {
		Employee emp = service.getEmployee(empId);
		m.addAttribute("emp", emp);
		return "viewemp";
	}


	@PostMapping("/employeeupdate")
	public String updateEmp(@ModelAttribute Employee emp, Model m) {
		System.out.println(emp);
		m.addAttribute("emp", service.updateEmployee(emp));
		return "viewemp";
	}

	@PostMapping("/getByEmployeeId1")
	public String getEmployeebyId1(@RequestParam("empId") int empId, Model m) {
		m.addAttribute("emp", service.getEmployee(empId));
		return "updateresult";
	}

}
