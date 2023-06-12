package com.example;

import com.example.interfaces.ICpu;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyClient {
    private final ICpu cpu;

    public MyClient(@Qualifier("intel") ICpu cpu) {
        this.cpu = cpu;
    }

    public void showSpeed() {
        cpu.speed();
    }

}
