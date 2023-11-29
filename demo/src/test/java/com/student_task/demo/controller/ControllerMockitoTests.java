package com.student_task.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.student_task.demo.entity.Student;
import com.student_task.demo.service.StudentService;
import com.student_task.demo.service.StudentServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerMockitoTests {

	@Mock
	StudentService studentServ;
	@InjectMocks
	StudentController studentController;
	@MockBean
	private StudentServiceImpl studentServiceImpl;
	
	@Autowired
	MockMvc mockMvc;

	List<Student> mystudents;
	Optional<Student> student;
	
	@Test
	void test_StudentServiceNotNull() {
		assertThat(studentServiceImpl).isNotNull();
	}
	
	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}
	

	@Test
	@Order(1)
	public void test_getstudents() {
		mystudents = new ArrayList<Student>();
		mystudents.add(new Student(1,"ritika",13,123345));
		mystudents.add(new Student(1,"ritika",19,123));

		when(studentServ.getAllStudents()).thenReturn(mystudents);// mocking
		ResponseEntity<List<Student>> res = studentController.getstudents();
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(2,res.getBody().size());
	}
	
	/* @Test
		void test_getStudentById() throws Exception {
			Optional<Student> user=Optional.of(new Student(101,"sana", 20,2345));
		when(studentServiceImpl.getStudentById(101)).thenReturn(student);
		mockMvc.perform(get("/get/101"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.id").value(101))
		.andExpect(jsonPath("$.name").value("sana"))
		.andExpect(jsonPath("$.salary").value(2345))
		.andExpect(jsonPath("$.age").value(20));
			
		} */
	 @Test
	    public void testGetStudentById() {
	        int studentId = 1;

	        // Mocking the behavior of the studentService.getStudentById method
	        Student mockStudent = new Student(/* Initialize your mock student object */);
	        Optional<Student> mockStudentOptional = Optional.of(mockStudent);
	        when(studentServ.getStudentById(eq(studentId))).thenReturn(mockStudentOptional);

	        // Calling the controller method
	        ResponseEntity<Optional<Student>> responseEntity = studentController.getStudentById(studentId);

	        // Assertions
	        verify(studentServ, times(1)).getStudentById(eq(studentId)); // Verify that the service method was called
	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); // Check the HTTP status code
	        assertTrue(responseEntity.getBody().isPresent()); // Check if the returned Optional contains a student
	        assertEquals(mockStudent, responseEntity.getBody().get()); // Check the content of the Optional
	    }
	 
	 @Test
		void test_addStudent() throws Exception {
			Student s1=new Student(101,"sana", 20,2345);
			Student s2=new Student(102,"sita", 20,2345);
			List<Student> studentList=new ArrayList<Student>();
			studentList.add(s1);
			studentList.add(s2);
			when(studentServ.getAllStudents()).thenReturn(studentList);
		mockMvc.perform(get("/student"));
			 
		}
	 
	 @Test
	    public void testUpdate() {
	        int studentId = 1;

	        // Mocking the behavior of the studentService.update method
	        // Assume that the update method returns void or some indicator of success
	        doNothing().when(studentServ).update(eq(studentId), any(Student.class));

	        // Calling the controller method
	        ResponseEntity<Void> responseEntity = studentController.update(studentId, new Student(/* Initialize your updated student object */));

	        // Assertions
	        verify(studentServ, times(1)).update(eq(studentId), any(Student.class)); // Verify that the service method was called
	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); // Check the HTTP status code
	    }
	 @Test
	    public void testDelete() {
	        int studentId = 1;

	        // Mocking the behavior of the studentService.deleteById method
	        doNothing().when(studentServ).deleteById(eq(studentId));

	        // Calling the controller method
	        ResponseEntity<String> responseEntity = studentController.delete(studentId);

	        // Assertions
	        verify(studentServ, times(1)).deleteById(eq(studentId)); // Verify that the service method was called
	        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode()); // Check the HTTP status code
	    }
	
	 
}

