package com.example.demo.controller.student;

import com.example.demo.repository.student.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        student.setId(null);
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student updateStudentInfo, @PathVariable Long id) {

        return ResponseEntity.ok(studentService.updateStudent(id, updateStudentInfo));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
