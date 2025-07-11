package com.lucas.designfactorybackend.repositories;

import com.lucas.designfactorybackend.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findByEmail(String email);
}
