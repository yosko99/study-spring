package com.yusuf;

import com.yusuf.interfaces.IVehicle;
import org.springframework.stereotype.Component;

@Component
public class Bike implements IVehicle {
    public void drive() {
        System.out.println("Ride bike");
    }
}
