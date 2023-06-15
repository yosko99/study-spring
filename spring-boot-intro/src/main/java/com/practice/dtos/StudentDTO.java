package com.practice.dtos;

import com.practice.entities.Laptop;

import java.util.List;

public record StudentDTO(String name, int age, List<Laptop> laptopList) {
}
