package com.fagenius.spring.data.jpa.demo.services;

import com.fagenius.spring.data.jpa.demo.entities.Student;
import com.fagenius.spring.data.jpa.demo.repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepositories studentRepositories;

    public List<Student> getAllStudent(){
        List<Student> students = new ArrayList<>();
        studentRepositories.findAll().forEach(students::add);
        return students;
    }

    public void addStudent(Student student){
        studentRepositories.save(student);
    }

    public Optional<Student> getStudent(String id){
        return studentRepositories.findById(id);
    }
    public void updateStudent(String id, Student student){
        studentRepositories.save(student);
    }


    public void deleteStudent(String id){
        studentRepositories.deleteById(id);
    }

}
