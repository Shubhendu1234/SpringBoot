package com.department_service.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department_service.dto.DepartmentDto;
import com.department_service.entities.Department;
import com.department_service.repositories.DepartmentRepository;
import com.department_service.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	
	
	DepartmentRepository departmentRepository;
	@Autowired
	ModelMapper mapper;
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		//convert departmentDto to department entity
		
		
//		Department department = new Department(
//				departmentDto.getId(),
//				departmentDto.getDepartmentName(),
//				departmentDto.getDepartDescription(),
//				departmentDto.getDepartmentCode()
//				);
		//mapper
		Department department = mapper.map(departmentDto, Department.class);
		Department savedDepartment = departmentRepository.save(department);
//		DepartmentDto savedDepartmentDto = new DepartmentDto(
//				savedDepartment.getId(),
//				savedDepartment.getDepartmentName(),
//				savedDepartment.getDepartmentDescription(),
//				savedDepartment.getDepartmentCode()
//				);
		
		DepartmentDto savedDepartmentDto = mapper.map(savedDepartment, DepartmentDto.class);
		
		return savedDepartmentDto;
	}
	//to get department by code
	@Override
	public DepartmentDto getDepartmentByCode(String depart_code) {
		// TODO Auto-generated method stub
		Department department = departmentRepository.findBydepartmentCode(depart_code);
//		DepartmentDto saveDto = new DepartmentDto(
//				department.getId(),
//				department.getDepartmentName(),
//				department.getDepartmentDescription(),
//				department.getDepartmentCode()
//				);
		
		DepartmentDto saveDto = mapper.map(department, DepartmentDto.class);
		return saveDto;
	}

}
