package com.department_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.department_service.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findBydepartmentCode(String depart_code);

	

}
