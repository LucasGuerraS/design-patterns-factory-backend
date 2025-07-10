package com.lucas.designfactorybackend.repositories;

import com.lucas.designfactorybackend.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
