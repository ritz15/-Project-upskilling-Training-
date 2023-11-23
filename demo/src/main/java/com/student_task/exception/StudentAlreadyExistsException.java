package com.student_task.exception;

public class StudentAlreadyExistsException extends Exception{

	
private String msg;
	
	public StudentAlreadyExistsException() {
		super();
	}
	
	public StudentAlreadyExistsException(String msg) {
		super();
		this.msg=msg;
	}
}
