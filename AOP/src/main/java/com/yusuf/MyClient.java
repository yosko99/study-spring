package com.yusuf;

import com.yusuf.interfaces.IAnimal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyClient {
    private final IAnimal animal;

    public MyClient(@Qualifier("dog") IAnimal animal) {
        this.animal = animal;
    }

    public void executeSound() {
        animal.sound();
    }
}
