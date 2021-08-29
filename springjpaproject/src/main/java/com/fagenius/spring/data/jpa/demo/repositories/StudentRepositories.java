package com.fagenius.spring.data.jpa.demo.repositories;

import com.fagenius.spring.data.jpa.demo.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositories extends CrudRepository<Student, String> {
}
