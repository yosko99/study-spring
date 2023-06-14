package com.practice.services;

import com.practice.entities.Laptop;
import com.practice.entities.Student;
import com.practice.interfaces.LaptopRepository;
import com.practice.interfaces.StudentRepository;
import com.practice.models.CreateStudentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final LaptopRepository laptopRepository;
    private final LaptopService laptopService;

    public StudentService(StudentRepository studentRepository, LaptopRepository laptopRepository, LaptopService laptopService) {
        this.studentRepository = studentRepository;
        this.laptopRepository = laptopRepository;
        this.laptopService = laptopService;
    }

    public Student retrieveStudent(int studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't find student with provided id"));
    }

    public Student createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student(createStudentRequest.name(), createStudentRequest.age());

        studentRepository.save(student);

        return student;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) throws ResponseStatusException {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id not found");
        }

        return student.get();
    }

    public Student addLaptopToStudent(int studentId, int laptopId) {
        Student student = retrieveStudent(studentId);
        Laptop laptop = laptopService.retrieveLaptop(laptopId);

        student.getLaptopList().add(laptop);
        laptop.setStudent(student);

        laptopRepository.save(laptop);
        studentRepository.save(student);

        return student;
    }
}
