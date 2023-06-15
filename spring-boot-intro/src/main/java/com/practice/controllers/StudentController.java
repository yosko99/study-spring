package com.practice.controllers;

import com.practice.dtos.StudentDTO;
import com.practice.entities.Student;
import com.practice.models.CreateStudentRequest;
import com.practice.services.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return studentService.createStudent(createStudentRequest);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable("id") int id) throws ResponseStatusException {
        return studentService.getStudentById(id);
    }

    @PostMapping("/{studentId}/laptop/{laptopId}")
    public Student addLaptopToStudent(@PathVariable("studentId") int studentId, @PathVariable("laptopId") int laptopId) {
        return studentService.addLaptopToStudent(studentId, laptopId);
    }
}
