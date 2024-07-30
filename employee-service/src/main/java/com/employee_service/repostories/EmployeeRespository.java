package com.employee_service.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_service.enities.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long>{

}
