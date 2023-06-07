package com.example;

import com.example.interfaces.IAnimal;
import org.springframework.stereotype.Component;

@Component
public class Dog implements IAnimal {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Dog");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
