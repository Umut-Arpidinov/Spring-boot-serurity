package com.example.Spring.boot.rest.service;

import com.example.Spring.boot.rest.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAllStudents();
    Optional<Student> findById(Long id);
    Student saveStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Long id);
}
