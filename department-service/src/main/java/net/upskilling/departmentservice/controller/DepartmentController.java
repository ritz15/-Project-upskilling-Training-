package net.upskilling.departmentservice.controller;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
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
import net.upskilling.departmentservice.dto.DepartmentDto;
import net.upskilling.departmentservice.service.DepartmentService;


@Tag(
        name = "CRUD REST APIs for DEPARTMENT Resource",
        description = "CRUD REST APIs - Create Department, Get Department"
) 
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
  public class DepartmentController {

	private DepartmentService departmentService;
	
	 @Operation(
	            summary = "Create User REST API",
	            description = "Create User REST API is used to save department in a database"
	    )
	    @ApiResponse(
	            responseCode = "201",
	            description = "HTTP Status 201 CREATED"
	    )
	//build saveDept REST 
   @PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		
		DepartmentDto saveDepartment =departmentService.saveDepartment(departmentDto);
	return new ResponseEntity<>(saveDepartment,HttpStatus.CREATED);
}
	  @Operation(
	            summary = "Get Department By Code REST API",
	            description = "Get Department By Code REST API is used to get a single department from the database"
	    )
	    @ApiResponse(
	            responseCode = "200",
	            description = "HTTP Status 200 SUCCESS"
	            )
   @GetMapping("{department-code}")
   public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
       DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
       return new ResponseEntity<>(departmentDto, HttpStatus.OK);
}
}