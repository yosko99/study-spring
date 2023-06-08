package com.example;

import com.example.interfaces.ICpu;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("amd")
public class Amd implements ICpu {
    @Override
    public void speed() {
        System.out.println("AMD 4.5 GHZ");
    }
}
