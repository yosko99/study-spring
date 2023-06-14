package com.practice.services;

import com.practice.entities.Laptop;
import com.practice.interfaces.LaptopRepository;
import com.practice.models.CreateLaptopRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public Laptop retrieveLaptop(int laptopId) {
        return laptopRepository.findById(laptopId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't find laptop with provided id"));
    }

    public List<Laptop> getLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop createLaptop(@RequestBody CreateLaptopRequest createLaptopRequest) {
        Laptop laptop = new Laptop(createLaptopRequest.brand(), createLaptopRequest.speed());

        laptopRepository.save(laptop);

        return laptop;
    }
}
