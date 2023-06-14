package com.practice.controllers;

import com.practice.entities.Laptop;
import com.practice.models.CreateLaptopRequest;
import com.practice.services.LaptopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping
    public List<Laptop> getLaptops() {
        return laptopService.getLaptops();
    }

    @PostMapping
    public Laptop createLaptop(@RequestBody CreateLaptopRequest createLaptopRequest) {
        return laptopService.createLaptop(createLaptopRequest);
    }
}
