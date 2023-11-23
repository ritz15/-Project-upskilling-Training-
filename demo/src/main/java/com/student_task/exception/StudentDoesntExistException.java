package com.student_task.exception;

public class StudentDoesntExistException  extends Exception{

	private String msg;
	
	public StudentDoesntExistException() {
		super();
	}
	public StudentDoesntExistException(String msg) {
		super();
		this.msg=msg;
	}
}
