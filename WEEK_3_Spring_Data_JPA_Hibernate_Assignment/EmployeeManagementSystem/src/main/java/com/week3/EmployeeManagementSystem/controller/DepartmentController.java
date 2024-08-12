package com.week3.EmployeeManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.week3.EmployeeManagementSystem.dto.DepartmentDTO;
import com.week3.EmployeeManagementSystem.model.Department;
import com.week3.EmployeeManagementSystem.projection.DepartmentProjection;
import com.week3.EmployeeManagementSystem.repository.DepartmentRepository;

//DepartmentController is added as part of Excercise 4 to implement CRUD operations
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;
    
    //Using DepartmentProjection in Controller class as required by Excercise 8 instructions
    @GetMapping("/projections")
    public List<DepartmentProjection> getAllDepartmentProjections() {
        return departmentRepository.findAllProjectedBy();
    }

    //Using DeparmentDTO in Controller class as required by Excercise 8 instructions
    @GetMapping("/dto")
    public List<DepartmentDTO> getAllDepartmentDTOs() {
        return departmentRepository.findAllDepartmentDTOs();
    }
    
    //Uses DepartmentRepository to implement CRUD operations as of Excercise 4
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    
    
    //Uses DepartmentRepository to implement CRUD operations as of Excercise 4
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
    //Uses DepartmentRepository to implement CRUD operations as of Excercise 4
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }
    
    
    //Uses DepartmentRepository to implement CRUD operations as of Excercise 4
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            Department updatedDepartment = department.get();
            updatedDepartment.setName(departmentDetails.getName());
            return ResponseEntity.ok(departmentRepository.save(updatedDepartment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    //Uses DepartmentRepository to implement CRUD operations as of Excercise 4
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}