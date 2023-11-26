package net.upskilling.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.upskilling.employeeservice.dto.APIResponseDto;
import net.upskilling.employeeservice.dto.EmployeeDto;
import net.upskilling.employeeservice.service.EmployeeService;
  

@Tag(
        name = "CRUD REST APIs for EMPLOYEE Resource",
        description = "CRUD REST APIs - Create Employee, Get Employee"
) 
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

	
	 private EmployeeService employeeService;
	 @Operation(
	            summary = "Create EMPLOYEE REST API",
	            description = "Create Employee REST API is used to save employee in a database"
	    )
	    @ApiResponse(
	            responseCode = "201",
	            description = "HTTP Status 201 CREATED"
	    )
	   @PostMapping
	    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
	        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
	        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
}
	 @Operation(
	            summary = "Get EMPLOYEE By Code REST API",
	            description = "Get Employee By Code REST API is used to get a single employee from the database"
	    )
	    @ApiResponse(
	            responseCode = "200",
	            description = "HTTP Status 200 SUCCESS"
	            )
	   @GetMapping("{id}")
	    public ResponseEntity< APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
	      APIResponseDto apiResponseDto = employeeService.getemployeeById(employeeId);
	        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	    }
	   
	
}
