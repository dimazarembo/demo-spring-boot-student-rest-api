package com.example.demo.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_sequence", allocationSize = 1)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //user cannot add own id by POST and still can see id by GET request
    private Long id;
    private String name;
    private Double salary;
    private LocalDate birthday;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //age calculated automatically so it has forbidden to be set in POST/PUT
    private Integer age;

    public Student() {

    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //конструктор для тестовых данных

    public Student(Long id, String name, double salary, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }
}
