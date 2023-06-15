package com.yusuf.demo.student;

import com.practice.dtos.StudentDTO;
import com.practice.dtos.StudentDTOMapper;
import com.practice.entities.Laptop;
import com.practice.entities.Student;
import com.practice.interfaces.LaptopRepository;
import com.practice.interfaces.StudentRepository;
import com.practice.models.CreateStudentRequest;
import com.practice.services.LaptopService;
import com.practice.services.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private LaptopRepository laptopRepository;
    @Mock
    private LaptopService laptopService;
    @Mock
    private StudentDTOMapper studentDTOMapper;

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        studentService = new StudentService(studentRepository, laptopRepository, laptopService, studentDTOMapper);
    }

    @Test
    void retrieveStudent_existingId_shouldReturnStudent() {
        // Arrange
        int studentId = 1;
        Student student = new Student("John", 20);
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        // Act
        Student result = studentService.retrieveStudent(studentId);

        // Assert
        assertEquals(student, result);
    }

    @Test
    void retrieveStudent_nonExistingId_shouldThrowException() {
        // Arrange
        int studentId = 1;
        when(studentRepository.findById(studentId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResponseStatusException.class, () -> studentService.retrieveStudent(studentId));
    }

    @Test
    void createStudent_validRequest_shouldCreateAndReturnStudent() {
        // Arrange
        CreateStudentRequest request = new CreateStudentRequest("John", 20);
        Student student = new Student(request.name(), request.age());
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        // Act
        Student result = studentService.createStudent(request);

        // Assert
        assertEquals(student, result);
        verify(studentRepository, times(1)).save(any(Student.class));
    }

    @Test
    void getStudents_shouldReturnListOfStudentDTOs() {
        // Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 20));
        when(studentRepository.findAll()).thenReturn(students);

        // Act
        List<StudentDTO> result = studentService.getStudents();

        // Assert
        assertNotNull(result);
        assertEquals(students.size(), result.size());
    }

    @Test
    void getStudentById_existingId_shouldReturnStudentDTO() {
        // Arrange
        int studentId = 1;
        Student student = new Student("John", 20);
        StudentDTO studentDTO = new StudentDTO("John", 20, List.of());
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentDTOMapper.apply(student)).thenReturn(studentDTO);

        // Act
        StudentDTO result = studentService.getStudentById(studentId);

        // Assert
        assertNotNull(result);
        assertEquals(studentDTO, result);
        verify(studentRepository, times(1)).findById(studentId);
        verify(studentDTOMapper, times(1)).apply(student);
    }

    @Test
    void addLaptopToStudent_existingIds_shouldAddLaptopAndReturnStudent() {
        // Arrange
        int studentId = 1;
        int laptopId = 2;
        Student student = new Student("John", 20);
        Laptop laptop = new Laptop();
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(laptopService.retrieveLaptop(laptopId)).thenReturn(laptop);
        when(studentRepository.save(student)).thenReturn(student);
        when(laptopRepository.save(laptop)).thenReturn(laptop);

        // Act
        Student result = studentService.addLaptopToStudent(studentId, laptopId);

        // Assert
        assertEquals(student, result);
        assertTrue(student.getLaptopList().contains(laptop));
        assertEquals(student, laptop.getStudent());
        verify(studentRepository, times(1)).save(student);
        verify(laptopRepository, times(1)).save(laptop);
    }
}
