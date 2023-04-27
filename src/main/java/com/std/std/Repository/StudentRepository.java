package com.std.std.Repository;

import com.std.std.model.Student;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


//JpaRepository<Student, Long>
public interface StudentRepository extends CrudRepository<Student, Long> {
}
