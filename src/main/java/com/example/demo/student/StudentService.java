package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public void addNewStudent(Student student) {
        Optional<Student>studentEmail = studentRepository.findStudentByMail(student.getEmail());
        if(studentEmail.isPresent()) {
            throw new IllegalArgumentException("Student already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exitst = studentRepository.existsById(studentId);
        if(!exitst) {
            throw new IllegalArgumentException("Student does not exist");
        }else{
            studentRepository.deleteById(studentId);
        }
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->
                new IllegalArgumentException("Student with id"+ studentId + "does not exits"));
        if(name != null &&
                name.length()>0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if(email != null &&
                email.length()>0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student>studentOptional = studentRepository.findStudentByMail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalArgumentException("Student already exists");
            }
            student.setEmail(email);
        }
    }
}
