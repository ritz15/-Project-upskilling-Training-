package com.example.SpringbootRestfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotfoundException  extends RuntimeException{

	private String resourceName;
	private String fieldName;
	private Long fieldValue;
	
	public ResourceNotfoundException( String resourceName,String fieldName, Long fieldValue) {
		 super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
	        this.resourceName = resourceName;
	        this.fieldName = fieldName;
	        this.fieldValue = fieldValue;
}
}
