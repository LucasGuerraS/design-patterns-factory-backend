package com.lucas.designfactorybackend.services;

import com.lucas.designfactorybackend.models.Student;
import com.lucas.designfactorybackend.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public Integer login(String email, String password) {
        Student student = studentRepository.findByEmail(email);
        return student != null && student.getPassword().equals(password) ? student.getId() : null;
    }

    public Integer completeClass(Integer id, Integer category) {
        Student student = studentRepository.getStudentById(id);
        return switch (category) {
            case 1 -> {
                student.setProgress_a(student.getProgress_a() + 1);
                student.setExperience(student.getExperience() + 1);
                yield studentRepository.save(student).getProgress_a();
            }
            case 2 -> {
                student.setProgress_b(student.getProgress_b() + 1);
                student.setExperience(student.getExperience() + 1);
                yield studentRepository.save(student).getProgress_b();
            }
            case 3 -> {
                student.setProgress_c(student.getProgress_c() + 1);
                student.setExperience(student.getExperience() + 1);
                yield studentRepository.save(student).getProgress_c();
            }
            default -> id;
        };
    }

    public Boolean emitCertificate(Integer id) {
        Student student = studentRepository.getStudentById(id);
        if (student == null) return false;
        if (student.getCertificate() == null || student.getCertificate()) return false;
        student.setCertificate(true);
        studentRepository.save(student);
        return true;
    }
}
