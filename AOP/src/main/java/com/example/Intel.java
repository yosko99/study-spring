package com.example;

import com.example.interfaces.ICpu;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("intel")
public class Intel implements ICpu {
    public void speed() {
        System.out.println("AMD 5 GHZ");
    }
}
