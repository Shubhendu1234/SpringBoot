package com.department_service.service;

import com.department_service.dto.DepartmentDto;

public interface DepartmentService {
	
	
	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentByCode(String depart_code);
	

}
