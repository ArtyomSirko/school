package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private long idGenerator = 1;

    public Student createStudent(Student student) {
        student.setId(idGenerator++);
        return student;
    }

    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Collection<Student> findByAgeStudents(int minAge, int maxAge) {
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public Faculty findFacultyAtStudent(long id) {
        return studentRepository.findFacultyById(id);
    }

    public Optional<Student> getById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public Integer getNumbersOfStudents() {
        return studentRepository.getNumbersOfStudents();
    }

    public Integer getAverageAge() {
        return studentRepository.getAverageAge();
    }

    public List<Student> lastFiveStudent() {
        return studentRepository.lastFiveStudent();
    }

}
