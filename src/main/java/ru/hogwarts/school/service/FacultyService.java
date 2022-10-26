package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();

    private Long count = 0L;

    public Faculty createFaculty(Faculty faculty) {
        faculties.put(count, faculty);
        count++;

        return faculty;
    }

    public Faculty getFacultyById(Long userId) {
        return faculties.get(userId);
    }

    public Faculty updateFaculty(Long userId, Faculty faculty) {
        faculties.put(count, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long userId) {
        return faculties.remove(userId);
    }
}
