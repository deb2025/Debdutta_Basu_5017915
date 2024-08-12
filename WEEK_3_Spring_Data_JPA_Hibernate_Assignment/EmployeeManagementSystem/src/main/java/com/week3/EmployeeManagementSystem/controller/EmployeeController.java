package com.week3.EmployeeManagementSystem.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.week3.EmployeeManagementSystem.dto.EmployeeDTO;
import com.week3.EmployeeManagementSystem.model.Employee;
import com.week3.EmployeeManagementSystem.projection.EmployeeProjection;
import com.week3.EmployeeManagementSystem.repository.EmployeeRepository;


//EmployeeController is added as part of Excercise 4 to implement CRUD operations
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    //Using EmployeeProjection in Controller class as required by Excercise 8 instructions
    @GetMapping("/projections")
    public List<EmployeeProjection> getAllEmployeeProjections() {
        return employeeRepository.findAllProjectedBy();
    }
    
    //Using EmployeeDTO in Controller class as required by Excercise 8 instructions
    @GetMapping("/dto")
    public List<EmployeeDTO> getAllEmployeeDTOs() {
        return employeeRepository.findAllEmployeeDTOs();
    }

    //This getAllEmployees method is update the controller class on paging and sorting functionalities as required by Excercise 6 
    public Page<Employee> getAllEmployees(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
    return employeeRepository.findAll(pageable);
    }
    
    //Uses EmployeeRepository to implement CRUD operations as of Excercise 4
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    //Uses EmployeeRepository to implement CRUD operations as of Excercise 4
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    //Uses EmployeeRepository to implement CRUD operations as of Excercise 4
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    
    
    //Uses EmployeeRepository to implement CRUD operations as of Excercise 4
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee updatedEmployee = employee.get();
            updatedEmployee.setName(employeeDetails.getName());
            updatedEmployee.setEmail(employeeDetails.getEmail());
            updatedEmployee.setDepartment(employeeDetails.getDepartment());
            return ResponseEntity.ok(employeeRepository.save(updatedEmployee));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // The /search endpoint is added to satisfy the instruction o	Combine pagination and sorting in your search endpoint of Excercise 6
    @GetMapping("/search")
    public Page<Employee> searchEmployees(@RequestParam String name,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(defaultValue = "id") String sortBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
    return employeeRepository.findByName(name, pageable);
    }
}