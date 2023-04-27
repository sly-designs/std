package com.std.std.Controller;

import com.std.std.Service.TeacherService;
import com.std.std.model.Student;
import com.std.std.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")

public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // Get all teachers
    @GetMapping("")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    // Get teacher by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
//        Optional<Teacher> teacher = teacherService.getTeacherById(id);
//        return teacher.map(value -> ResponseEntity.ok().body(value))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//                new ResponseEntity<>(teacher, HttpStatus.OK);
//    }

      // Create a new teacher
    @PostMapping("")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeacher);
    }


    // Update an existing teacher by id
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Integer id, @RequestBody Teacher teacher) {

        Optional<Teacher> existingTeacher = teacherService.getTeacherById(id);
        if (existingTeacher.isPresent()) {
            Teacher updatedTeacher = existingTeacher.get();
            updatedTeacher.setName(teacher.getName());
            teacherService.saveTeacher(updatedTeacher);
            return ResponseEntity.ok().body(updatedTeacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     // Delete a teacher by id

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacherById(@PathVariable Integer id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        if (teacher.isPresent()) {
            teacherService.deleteTeacherById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Delete all teachers
    @DeleteMapping
    public ResponseEntity<Void> deleteAllTeachers() {
        teacherService.deleteAllTeachers();
        return ResponseEntity.ok().build();
    }
}
