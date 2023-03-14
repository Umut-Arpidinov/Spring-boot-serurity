package com.example.Spring.boot.rest.controller;


import com.example.Spring.boot.rest.model.Student;
import com.example.Spring.boot.rest.repository.StudentRepository;
import com.example.Spring.boot.rest.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class RestController {

    private final StudentServiceImpl studentServiceImpl;

    public RestController(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("allStudentList",studentServiceImpl.findAllStudents());
        return "index";
    }
    @GetMapping("/addNew")
    public String addNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "newStudent";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("student") Student student){
        studentServiceImpl.saveStudent(student);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value ="id") long id,Model model){
        Optional<Student> student = studentServiceImpl.findById(id);
        model.addAttribute("student",student);
        return "update";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteById(@PathVariable(value = "id")long id){
        studentServiceImpl.deleteStudent(id);
        return "redirect:/";
    }
}
