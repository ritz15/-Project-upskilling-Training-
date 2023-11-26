package net.upskilling.employeeservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.LoggerFactory;
//import org.sl4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import lombok.extern.java.Log;
import net.upskilling.employeeservice.entity.Employee;
import net.upskilling.employeeservice.mapper.EmployeeMapper;
import net.upskilling.employeeservice.dto.APIResponseDto;
import net.upskilling.employeeservice.dto.DepartmentDto;
import net.upskilling.employeeservice.dto.EmployeeDto;
import net.upskilling.employeeservice.dto.OrganizationDto;
import net.upskilling.employeeservice.repository.EmployeeRepository;
import net.upskilling.employeeservice.service.APIClient;
import net.upskilling.employeeservice.service.EmployeeService;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	
	
	//private RestTemplate restTemplate;
	private WebClient webClient;
	private APIClient apiClient;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
		
				
	Employee savedEmployee=	employeeRepository.save(employee);
	
	EmployeeDto savedEmployeeDto= EmployeeMapper.mapToEmployeeDto(savedEmployee);
		return savedEmployeeDto;
	}
	
    @Retry(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	//@CircuitBreaker(name= " ${spring.application.name}", fallbackMethod = "getDafaultDepartment")
	@Override
	public APIResponseDto getemployeeById(Long employeeId) {

    	LOGGER.info("inside getEmployeeById() method");
		Employee employee =employeeRepository.findById(employeeId).get();
		
	/*	 ResponseEntity<DepartmentDto> responseEntity =  restTemplate.getForEntity("http://localhost:8080/api/departments" +employee.getDepartmentCode(), 
    		 DepartmentDto.class);
		 
		DepartmentDto departmentDto = responseEntity.getBody(); */
		
		DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
	
		
	//DepartmentDto departmentDto=apiClient.getDepartment(employee.getDepartmentCode());
	
		OrganizationDto organizationDto= webClient.get()
				.uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode())
				.retrieve()
				.bodyToMono(OrganizationDto.class)
				.block();
		
		EmployeeDto	employeeDto =EmployeeMapper.mapToEmployeeDto(employee);
		
		 APIResponseDto apiResponseDto= new APIResponseDto();
		 apiResponseDto.setEmployee(employeeDto);
		 apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setOrganization(organizationDto);
		return apiResponseDto;
	}
	//fallback method
	public APIResponseDto getDafaultDepartment(Long employeeId , Exception exception) {
		LOGGER.info("inside getDafaultDepartment() method"); 
		Employee employee= employeeRepository.findById(employeeId).get();
		   
		 DepartmentDto departmentDto= new DepartmentDto();
		 departmentDto.setDepartmentName("R&D Department");
		 departmentDto.setDepartmentDescription("reserach and development department");
		 departmentDto.setDepartmentCode("RD001");
		 
		   EmployeeDto	employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
		
		 APIResponseDto apiResponseDto= new APIResponseDto();
		 apiResponseDto.setEmployee(employeeDto);
		 apiResponseDto.setDepartment(departmentDto);
		
		return apiResponseDto;
	}
}
