package net.upskilling.employeeservice.service;

import net.upskilling.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    
    EmployeeDto getemployeeById(Long employeeDto);
}
