package com.std.std.Controller;

import com.std.std.Service.DepartmentService;
import com.std.std.model.Department;
import com.std.std.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Get all departments
    @GetMapping("")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // Get department by id

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        return department.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new department
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }

    // Update an existing department by id

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        Optional<Department> existingDepartment = departmentService.getDepartmentById(id);
        if (existingDepartment.isPresent()) {
            Department updatedDepartment = existingDepartment.get();
            updatedDepartment.setName(department.getName());
            departmentService.saveDepartment(updatedDepartment);
            return ResponseEntity.ok().body(updatedDepartment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Delete a department by id

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        if (department.isPresent()) {
            departmentService.deleteDepartmentById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete all departments
    @DeleteMapping
    public ResponseEntity<Void> deleteAllDepartments() {
        departmentService.deleteAllDepartments();
        return ResponseEntity.ok().build();
    }
}
