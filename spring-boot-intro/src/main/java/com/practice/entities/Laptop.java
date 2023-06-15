package com.practice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

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
        return "Laptop{" + "id=" + id + ", brand='" + brand + '\'' + ", speed=" + speed + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return id == laptop.id && Objects.equals(brand, laptop.brand) && Objects.equals(speed, laptop.speed) && Objects.equals(student, laptop.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, speed, student);
    }
}
