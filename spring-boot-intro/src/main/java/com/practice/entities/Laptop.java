package com.practice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
    @Id
    @GeneratedValue
    private int id;
    private String brand;
    private Float speed;
    @ManyToOne
    @JsonBackReference
    private Student student;

    public Laptop() {

    }

    public Laptop(String brand, Float speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public Laptop(String brand, Float speed, Student student) {
        this.brand = brand;
        this.speed = speed;
        this.student = student;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" + "id=" + id + ", brand='" + brand + '\'' + ", speed=" + speed + ", student=" + student.toString() + '}';
    }
}
