package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
public class StudentByCategory {
    private final StudentService studentService;

    public StudentByCategory(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/numbers_of_students")
   public Integer getNumberOfStudent() {
        return studentService.getNumbersOfStudents();
    }

    @GetMapping("/average_age")
  public   Integer getAverageAge() {
        return studentService.getAverageAge();
    }

    @GetMapping("/last_5_student")
   public List<Student> lastFiveStudent() {
        return studentService.lastFiveStudent();}

}
