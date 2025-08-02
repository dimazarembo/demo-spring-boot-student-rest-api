package com.example.demo.repository;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitStudentDataGenerator {

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void init() {
//        Student dima = new Student();
//        dima.setName("Dima");
//        dima.setSalary(5000);
//        dima.setBirthday(LocalDate.of(1991, 7, 3));
//        dima.setAge(34);
//        studentRepository.save(dima);
//
//        Student karina = new Student();
//        karina.setName("Karina");
//        karina.setSalary(10000);
//        karina.setBirthday(LocalDate.of(1996, 1, 14));
//        karina.setAge(29);
//        studentRepository.save(karina);
    }
}
