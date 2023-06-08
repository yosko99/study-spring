package com.yusuf;

import com.yusuf.interfaces.IAnimal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("dog")
public class Dog implements IAnimal  {
    public void sound() {
        System.out.println("Bow bow");
    }
}
