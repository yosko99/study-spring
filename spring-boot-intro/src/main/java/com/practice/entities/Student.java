package com.practice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    @JsonIgnoreProperties("student")
    @OneToMany(mappedBy = "student")
    private List<Laptop> laptopList;

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
}
