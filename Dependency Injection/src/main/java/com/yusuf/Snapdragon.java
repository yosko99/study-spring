package com.yusuf;

import com.yusuf.interfaces.IMobileProcessor;
import org.springframework.stereotype.Component;

@Component
public class Snapdragon implements IMobileProcessor {
    private Integer speed;

    public Snapdragon() {
        // Default constructor
    }

    public Snapdragon(Integer speed) {
        this.speed = speed;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public void process() {
        System.out.println("Snapdragon CPU " + speed);
    }
}
