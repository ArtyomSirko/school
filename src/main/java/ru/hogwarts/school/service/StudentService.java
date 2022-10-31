package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private final Map<Long, Student> students = new HashMap<>();
    private Long count = 0L;

    public Student createUser(Student student) {
        student.setId(count);
        students.put(count, student);
        count++;
        return student;
    }

    public Student getUserById(Long userId) {
        return students.get(userId);
    }

    public Student updateUser(Long userId, Student student) {
        students.put(count, student);
        return student;
    }

    public Student deleteUser(Long userId) {
        return students.remove(userId);
    }
}
