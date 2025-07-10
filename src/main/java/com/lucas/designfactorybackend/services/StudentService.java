package com.lucas.designfactorybackend.services;

import com.lucas.designfactorybackend.models.Student;
import com.lucas.designfactorybackend.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }
}
