package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    Integer getNumbersOfStudents();

    @Query(value = "SELECT avg(age) FROM student", nativeQuery = true)
    Integer getAverageAge();

    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> lastFiveStudent();



    Collection<Student> findByAgeBetween(int minAge, int maxAge);

    Faculty findFacultyById(long id);

    Student findByName(String name);

}
