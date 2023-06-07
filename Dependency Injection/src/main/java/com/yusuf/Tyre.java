package com.yusuf;

import org.springframework.stereotype.Component;

@Component
public class Tyre {
//    public Tyre(String brand) {
//        this.brand = brand;
//    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "brand='" + brand + '\'' +
                '}';
    }

    private String brand;
}
