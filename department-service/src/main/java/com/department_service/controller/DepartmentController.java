package com.department_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department_service.dto.DepartmentDto;
import com.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
	
	
	private DepartmentService departmentService;
	
	//build save department REST API
	
	@PostMapping()
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto)
	{
		DepartmentDto savedDepartemnt = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartemnt,HttpStatus.CREATED);
	}
	
	//build department rest api to getdepartment by code
	
	
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getByCode(@PathVariable("department-code") String code){
	DepartmentDto departmentDto = 	departmentService.getDepartmentByCode(code);
	return new ResponseEntity<>(departmentDto,HttpStatus.OK);
	}
	
	
	
}
