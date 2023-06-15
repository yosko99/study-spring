package com.practice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    @JsonIgnoreProperties("student")
    @OneToMany(mappedBy = "student")
    private List<Laptop> laptopList = new ArrayList<>();

    public Student(String name, int age, List<Laptop> laptopList) {
        this.name = name;
        this.laptopList = laptopList;
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Laptop> getLaptopList() {
        return laptopList;
    }

    public void setLaptopList(List<Laptop> laptopList) {
        this.laptopList = laptopList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", laptopList=" + laptopList.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name) && Objects.equals(laptopList, student.laptopList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, laptopList);
    }
}
