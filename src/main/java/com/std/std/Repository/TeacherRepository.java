package com.std.std.Repository;


import com.std.std.model.Teacher;
import org.springframework.data.repository.CrudRepository;

//JpaRepository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
