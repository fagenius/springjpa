package com.fagenius.spring.data.jpa.demo.controllers;


import com.fagenius.spring.data.jpa.demo.entities.Student;
import com.fagenius.spring.data.jpa.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        List<Student> students = studentService.getAllStudent();
        return students;
    }

    @RequestMapping(value = "/students/{id}")
    public Optional<Student> getStudent(@PathVariable String id){
        return studentService.getStudent(id);
    }

    @RequestMapping(value = "/students/{id}",method = RequestMethod.PUT)
    public void updateStudent(@PathVariable String id, @RequestBody Student student){
        studentService.updateStudent(id,student);
    }

    @RequestMapping(value = "students/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable String id){

    }

}
