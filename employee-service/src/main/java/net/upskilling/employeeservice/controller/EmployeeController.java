package net.upskilling.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.upskilling.employeeservice.dto.EmployeeDto;
import net.upskilling.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

	
	 private EmployeeService employeeService;
	 
	   @PostMapping
	    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
	        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
	        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
}
	   
	   @GetMapping("{id}")
	    public ResponseEntity< EmployeeDto > getEmployee(@PathVariable("id") Long employeeId){
	        EmployeeDto employeeDto = employeeService.getemployeeById(employeeId);
	        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	    } 
	
}
