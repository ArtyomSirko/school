package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Set;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Set<Student> findStudentById(long id);
}
