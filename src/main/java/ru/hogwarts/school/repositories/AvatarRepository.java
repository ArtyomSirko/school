package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
   Avatar findAvatarByStudentId(Long id);

   @Query(value = "SELECT * FROM avatar", nativeQuery = true)
   List<Avatar> getAvatarsOfStudents();
}
