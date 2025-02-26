package com.Student.Management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Student.Management.Model.Employee;
import com.Student.Management.repository.EmployeeRepository;

@RestController
@RequestMapping("app/")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}
	@GetMapping("/empinfo")
	public List<Employee> getAllEmployeeInfo()
	{
		return employeeRepository.findAll();
	}
	@GetMapping("employee/{eid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long eid) throws ResourceNotFoundException
	{
		Employee emp=employeeRepository.findById(eid)
				.orElseThrow(()->new ResourceNotFoundException("Employee not found"));
		return ResponseEntity.ok().body(emp);
	}
	@PutMapping("updateemp/{eid}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long eid,@RequestBody Employee empReq) throws ResourceNotFoundException
	{
		Employee emp=employeeRepository.findById(eid)
				.orElseThrow(()->new ResourceNotFoundException("Employee not found"));
		
		emp.setFname(empReq.getFname());
		emp.setLname(empReq.getLname());
		emp.setAge(empReq.getAge());
		emp.setAge(empReq.getAge());
		emp.setSalary(empReq.getSalary());
		Employee updateemp=employeeRepository.save(emp);
		return ResponseEntity.ok(updateemp);
		
		
	}

}
