package com.yusuf.demo;

import com.practice.entities.Laptop;
import com.practice.interfaces.LaptopRepository;
import com.practice.models.CreateLaptopRequest;
import com.practice.services.LaptopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LaptopServiceTest {

    @Mock
    private LaptopRepository laptopRepository;

    private LaptopService laptopService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        laptopService = new LaptopService(laptopRepository);
    }

    @Test
    public void testRetrieveLaptop_ExistingLaptopId_ReturnsLaptop() {
        // Arrange
        int laptopId = 1;
        Laptop laptop = new Laptop("Dell", 2F);
        when(laptopRepository.findById(laptopId)).thenReturn(Optional.of(laptop));

        // Act
        Laptop result = laptopService.retrieveLaptop(laptopId);

        // Assert
        assertNotNull(result);
        assertEquals(laptop, result);
        verify(laptopRepository, times(1)).findById(laptopId);
    }

    @Test
    public void testRetrieveLaptop_NonExistingLaptopId_ThrowsException() {
        // Arrange
        int laptopId = 1;
        when(laptopRepository.findById(laptopId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ResponseStatusException.class, () -> laptopService.retrieveLaptop(laptopId));
        verify(laptopRepository, times(1)).findById(laptopId);
    }

    @Test
    public void testGetLaptops_ReturnsListOfLaptops() {
        // Arrange
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Dell", 2F));
        laptops.add(new Laptop("HP", 3F));
        when(laptopRepository.findAll()).thenReturn(laptops);

        // Act
        List<Laptop> result = laptopService.getLaptops();

        // Assert
        assertNotNull(result);
        assertEquals(laptops, result);
        verify(laptopRepository, times(1)).findAll();
    }

    @Test
    public void testCreateLaptop_ValidRequest_ReturnsCreatedLaptop() {
        // Arrange
        CreateLaptopRequest request = new CreateLaptopRequest("Dell", 2F);
        Laptop savedLaptop = new Laptop("Dell", 2F);
        when(laptopRepository.save(any(Laptop.class))).thenReturn(savedLaptop);

        // Act
        Laptop result = laptopService.createLaptop(request);

        // Assert
        assertNotNull(result);
        assertEquals(savedLaptop, result);
        verify(laptopRepository, times(1)).save(any(Laptop.class));
    }
}
