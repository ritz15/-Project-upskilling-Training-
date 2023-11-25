package com.student_task.demo.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTests {

Student student;
	
	@BeforeEach
	public void before() {
		student= new Student(1,"ritika", 10, 1234);
	}
	
	@AfterEach
	public void after(){
		student=null;
		}
	@Test
	void test_GetId() {
		assertEquals(1, student.getId());
	}
	@Test
	void test_GetName() {
		assertEquals("ritika", student.getName());
	}
	@Test
	void test_GetAge() {
		assertEquals(10, student.getAge());
	}
	@Test
	void test_GetSalary() {
		assertEquals(1234, student.getSalary());
	}
	@Test
	void test_SetId() {
		student.setId(1);
		assertEquals(1, student.getId());
	}

	@Test
	void test_SetName() {
		student.setName("ritika");
		assertEquals("ritika", student.getName());
	}
	@Test
	void test_SetAge() {
		student.setAge(12);
		assertEquals(12, student.getAge());
	}
	@Test
	void test_SetSalary() {
		student.setSalary(12345);
		assertEquals(12345, student.getSalary());
	}

	
}
