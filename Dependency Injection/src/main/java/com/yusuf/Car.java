package com.yusuf;

import com.yusuf.interfaces.IVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements IVehicle {
    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Autowired
    private Tyre tyre;

    public void drive() {
        System.out.println("car " + tyre);
    }
}
