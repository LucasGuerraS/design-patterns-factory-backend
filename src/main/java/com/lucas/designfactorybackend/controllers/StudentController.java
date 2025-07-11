package com.lucas.designfactorybackend.controllers;

import com.lucas.designfactorybackend.models.Student;
import com.lucas.designfactorybackend.repositories.StudentRepository;
import com.lucas.designfactorybackend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(student));
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping
    @RequestMapping("/email/{email}")
    public ResponseEntity<Student> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(studentService.findByEmail(email));
    }
}
