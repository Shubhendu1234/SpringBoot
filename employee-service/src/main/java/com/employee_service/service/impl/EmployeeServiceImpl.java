package com.employee_service.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee_service.dto.ApiResponseDto;
import com.employee_service.dto.DepartmentDto;
import com.employee_service.dto.EmployeeDto;
import com.employee_service.enities.Employee;
import com.employee_service.feign.EmployeeInterface;
import com.employee_service.repostories.EmployeeRespository;
import com.employee_service.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRespository employeeRespository;
	
	@Autowired
	private EmployeeInterface employeeInterface;
	//	@Autowired
	//	private RestTemplate restTemplate;
	@Autowired
	ModelMapper modelMapper;

//	@Autowired
//	private WebClient webClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		//		Employee employee = new Employee(employeeDto.getId(),
		//				employeeDto.getFirstName(),employeeDto.getLastName(),
		//				employeeDto.getEmail());
		Employee employee = modelMapper.map(employeeDto, Employee.class);

		Employee savedEmployed = employeeRespository.save(employee);

		//		EmployeeDto savedEmployeeDto = new EmployeeDto(
		//				savedEmployed.getId(),savedEmployed.getFirstName(),
		//				savedEmployed.getLastName(),savedEmployed.getEmail()
		//				);

		//modelmapper
		EmployeeDto savedEmployeeDto 	= modelMapper.map(savedEmployed, EmployeeDto.class);





		return savedEmployeeDto;
	}
	
	
	
	//get employee by id
	@Override
	public ApiResponseDto getEmployeeById(Long id) {
		// TODO Auto-generated method stub


		Optional<Employee> employee =	employeeRespository.findById(id);
		if(employee.isEmpty())
		{

		}

		Employee emp = employee.get();

		//		EmployeeDto empDto = new EmployeeDto(emp.getId(),
		//				emp.getFirstName(),
		//				emp.getLastName(),
		//				emp.getEmail()
		//				);

		//Mapper

		//	ResponseEntity<DepartmentDto> responseEntity =	restTemplate.getForEntity(
		//				"http://localhost:8080/api/departments/"
		//		+employee.get().getDepartmentCode(), DepartmentDto.class);
		EmployeeDto empDto = modelMapper.map(emp, EmployeeDto.class);

// web client 
//		DepartmentDto departmentDto =	webClient.get()
//				.uri("http://localhost:8080/api/departments/"
//						+employee.get().getDepartmentCode()).retrieve()
//				.bodyToMono(DepartmentDto.class).block();
		
		//rest template
		//DepartmentDto departmentDto = responseEntity.getBody();

		
//Feign client
		System.out.println(empDto.getDepartmentCode());
		DepartmentDto departmentDto = employeeInterface.getByCode(empDto.getDepartmentCode());
		//DepartmentDto departmentDto = departmentDtos.getBody();
		ApiResponseDto apiResponseDto = new ApiResponseDto(empDto,
				departmentDto);



		return apiResponseDto;


	}

}
