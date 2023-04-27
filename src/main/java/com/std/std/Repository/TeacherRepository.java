package com.std.std.Repository;


import com.std.std.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//JpaRepository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
