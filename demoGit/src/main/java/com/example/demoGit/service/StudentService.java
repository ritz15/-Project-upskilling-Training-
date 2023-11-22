package com.example.demoGit.service;

import com.example.demoGit.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();
}
