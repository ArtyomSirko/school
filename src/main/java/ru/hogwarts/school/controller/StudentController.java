package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long userId) {
        Student student = studentService.getStudentById(userId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        if (updatedStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long userId) {
        studentService.deleteStudent(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam int minAge, @RequestParam int maxAge) {
        if (maxAge >= 0 && minAge >= 0) {
            return ResponseEntity.ok(studentService.findByAgeStudents(minAge, maxAge));
        }
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/findFaculty/{userId}")
    public ResponseEntity<Faculty> findFacultyAtStudentId(@PathVariable Long userId) {
        Faculty facultyAtStudent = studentService.findFacultyAtStudent(userId);
        return ResponseEntity.ok(facultyAtStudent);
    }


}

