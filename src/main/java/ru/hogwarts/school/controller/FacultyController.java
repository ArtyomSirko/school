package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RequestMapping("/faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping
    public ResponseEntity createUser(@RequestBody Faculty faculty) {
        Faculty createdUser = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createdUser);
    }
    @GetMapping("/{userId}")
    public ResponseEntity getUser(@PathVariable Long userId) {
        Faculty faculty = facultyService.getFacultyById(userId);
        if(faculty == null) {
            return ResponseEntity.notFound() .build();
        }
        return ResponseEntity.ok(faculty);
    }
    @PutMapping()
    public ResponseEntity updateUser(@RequestBody Faculty user) {
        Faculty updatedUser = facultyService.updateFaculty(user.getId(), user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        Faculty faculty = facultyService.deleteFaculty(userId);
        if(faculty == null) {
            return ResponseEntity.notFound() .build();
        }
        return ResponseEntity.ok(faculty);
    }
}
