package net.upskilling.employeeservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.upskilling.employeeservice.entity.Employee;
import net.upskilling.employeeservice.dto.EmployeeDto;
import net.upskilling.employeeservice.repository.EmployeeRepository;
import net.upskilling.employeeservice.service.EmployeeService;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		Employee employee= new Employee(
				           employeeDto.getId(),
				           employeeDto.getFirstName(),
				           employeeDto.getLastName(),
				           employeeDto.getEmail()
				           );
				
	Employee savedEmployee=	employeeRepository.save(employee);
	
	EmployeeDto savedEmployeeDto= new EmployeeDto(
			savedEmployee.getId(),
			savedEmployee.getFirstName(),
			savedEmployee.getLastName(),
			savedEmployee.getEmail()
			);
		return savedEmployeeDto;
	}

	@Override
	public EmployeeDto getemployeeById(Long employeeId) {

		Employee employee =employeeRepository.findById(employeeId).get();
		EmployeeDto	employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);
		
		
		return employeeDto;
	}
	

}
