package com.example.demo.service;

import com.example.demo.repository.student.Student;
import com.example.demo.repository.student.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        student.setAge(calculateStudentAge(student));
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student for delete not found"));
        studentRepository.delete(student);

    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student for getById not found"));
    }

    @Transactional
    public Student updateStudent(Long id, Student updateStudentInfo) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student for update not found"));

        if (updateStudentInfo.getName() != null) {
            student.setName(updateStudentInfo.getName());
        }
        if (updateStudentInfo.getSalary() != null) {
            student.setSalary(updateStudentInfo.getSalary());
        }
        if (updateStudentInfo.getBirthday() != null) {
            student.setBirthday(updateStudentInfo.getBirthday());
            student.setAge(calculateStudentAge(student));
        }
        if (updateStudentInfo.getAge() != null) {
            student.setAge(updateStudentInfo.getAge());
        }
        return student;
    }

    public int calculateStudentAge(Student student) {
        return Period.between(student.getBirthday(), LocalDate.now()).getYears();
    }
}
