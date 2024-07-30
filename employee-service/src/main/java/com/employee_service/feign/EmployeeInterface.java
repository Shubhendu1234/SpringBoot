package com.employee_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee_service.dto.DepartmentDto;

@FeignClient(name = "department-service")
public interface EmployeeInterface {

    @GetMapping("/api/departments/{departmentCode}")
    public DepartmentDto getByCode(@PathVariable("departmentCode") String code);

}
