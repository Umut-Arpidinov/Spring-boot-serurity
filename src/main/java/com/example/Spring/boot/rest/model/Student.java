package com.example.Spring.boot.rest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students_tracker")
public class Student {
    @GeneratedValue
    @Id
    private long id;

    @Column
    private String name;

    @Column
    private double gpa;

    @Column
    private int grade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }



}
