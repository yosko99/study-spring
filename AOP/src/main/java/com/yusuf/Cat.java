package com.yusuf;

import com.yusuf.interfaces.IAnimal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cat")
public class Cat implements IAnimal {
    @Override
    public void sound() {
        System.out.println("Meow");
    }
}
