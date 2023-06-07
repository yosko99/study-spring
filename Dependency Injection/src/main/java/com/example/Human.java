package com.example;

import com.example.interfaces.IAnimal;
import com.example.interfaces.IHuman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Human implements IHuman {
    @Autowired
    private IAnimal animal;

    @Override
    public void has() {
        System.out.println("The human has a " + animal);
    }
}
