package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById (long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public Student updateStudent( Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Collection<Student> findByAgeStudents(int minAge,int maxAge){
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public Faculty findFacultyAtStudent(long id) {
        return studentRepository.findFacultyById(id);
    }
}
