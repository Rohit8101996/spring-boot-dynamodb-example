package com.rohitbaranwal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohitbaranwal.entity.Employee;
import com.rohitbaranwal.repository.EmployeeRepository;

@RestController
public class DynamoDbController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{
		return employeeRepository.save(emp);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String empId, @RequestBody Employee emp)
	{
		return employeeRepository.update(emp, empId);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") String empId)
	{
		return employeeRepository.delete(empId);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") String empId)
	{
		return employeeRepository.getEmployeeById(empId);
	}

}

