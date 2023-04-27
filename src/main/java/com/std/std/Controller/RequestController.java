package com.std.std.Controller;


import com.std.std.Service.DepartmentService;
import com.std.std.Service.StudentService;
import com.std.std.Service.TeacherService;
import com.std.std.model.Department;
import com.std.std.model.Request;
import com.std.std.model.Student;
import com.std.std.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class RequestController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;


    @GetMapping("/save")
    public ResponseEntity<String> saveDetails(@RequestBody Request request) {

        Student student = new Student();
        student.setName(request.getStudentName());
        Student savedStudent = studentService.saveStudent(student);

        Teacher teacher = new Teacher();
        teacher.setName(request.getTeacherName());
        Teacher savedTeacher = teacherService.saveTeacher(teacher);


        Department department = new Department();
        department.setName(request.getDepartmentName());
        department.setStudentId(student.getId());
        department.setTeacherId(savedTeacher.getId());
        departmentService.saveDepartment(department);

        return ResponseEntity.ok().body("saved");

    }
    
}
