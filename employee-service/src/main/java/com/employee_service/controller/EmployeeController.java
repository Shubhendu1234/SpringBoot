package com.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_service.dto.ApiResponseDto;
import com.employee_service.dto.EmployeeDto;
import com.employee_service.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
	{
		EmployeeDto savedemployeeDto =	employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedemployeeDto,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("id") Long id)
	{
		System.out.println("id is-  "+id);
		ApiResponseDto employeeDto = employeeService.getEmployeeById(id);
		return new ResponseEntity<>(employeeDto,HttpStatus.FOUND);
		
	}
	
	
	
	
}
