package com.sakha.boot.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int empId;
	String id;
	String empName;
	int age;
	float salary;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate dob;

	public Employee() {
		super();
	}

	public Employee(String empName, int age, float salary, LocalDate dob, String id) {
		super();
		this.empName = empName;
		this.age = age;
		this.salary = salary;
		this.dob = dob;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", id=" + id + ", empName=" + empName + ", age=" + age + ", salary="
				+ salary + ", dob=" + dob + "]";
	}

}
