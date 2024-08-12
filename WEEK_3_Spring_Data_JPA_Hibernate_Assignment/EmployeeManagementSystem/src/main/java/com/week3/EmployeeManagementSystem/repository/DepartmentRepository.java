package com.week3.EmployeeManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.week3.EmployeeManagementSystem.dto.DepartmentDTO;
import com.week3.EmployeeManagementSystem.model.Department;
import com.week3.EmployeeManagementSystem.projection.DepartmentProjection;


//DepartmentRepository and derived query methods are added as part of Excercise 3 instructions 
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	//findAllEmployeeDTOs method added as part of Excercise 8 to define class based projections
	//@Query queries are added as part of Exercise 5 instructions
	@Query("SELECT new com.example.DepartmentDTO(d.id, d.name) FROM Department d")
    List<DepartmentDTO> findAllDepartmentDTOs();
	
	//findAllProjectedBy() added as part of instructions by Excercise 8 to define interface based projections
	List<DepartmentProjection> findAllProjectedBy();
	Department findByName(String name);
	
}
