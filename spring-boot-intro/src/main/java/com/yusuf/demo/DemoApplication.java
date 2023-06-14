package com.yusuf.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/horses")
public class DemoApplication {
    private final HorseRepository horseRepository;

    public DemoApplication(HorseRepository personRepository) {
        this.horseRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping
    public List<Horse> getHorses() {
        return horseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Horse> getHorseById(@PathVariable("id") int id) {
        return horseRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Horse updateHorseById(@PathVariable("id") int id, @RequestBody UpdateHorseRequest updateHorseRequest) throws ResponseStatusException {
        Optional<Horse> optionalHorse = horseRepository.findById(id);

        if (optionalHorse.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "horse with provided id not found");
        }

        Horse updatedHorse = optionalHorse.get();
        updatedHorse.setName(updateHorseRequest.name);
        horseRepository.save(updatedHorse);
        return updatedHorse;
    }

    @PostMapping
    public void createHorse(@RequestBody CreateHorseRequest createHorseRequest) {
        Horse horse = new Horse(createHorseRequest.name());

        horseRepository.save(horse);
    }

    record UpdateHorseRequest(String name) {
    }

    record CreateHorseRequest(String name) {
    }

}
