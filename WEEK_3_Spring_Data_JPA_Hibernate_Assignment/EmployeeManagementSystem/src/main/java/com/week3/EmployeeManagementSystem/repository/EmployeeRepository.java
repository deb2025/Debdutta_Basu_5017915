package com.week3.EmployeeManagementSystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.week3.EmployeeManagementSystem.dto.EmployeeDTO;
import com.week3.EmployeeManagementSystem.model.Department;
import com.week3.EmployeeManagementSystem.model.Employee;
import com.week3.EmployeeManagementSystem.projection.EmployeeProjection;

//EmployeeRepository and derived query methods are added as part of Excercise 3 instructions 
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	//findAllEmployeeDTOs method added as part of Excercise 8 to define class based projections
	//@Query queries are added as part of Exercise 5 instructions
	@Query("SELECT new com.example.EmployeeDTO(e.id, e.name, e.email, e.department.name) FROM Employee e")
    List<EmployeeDTO> findAllEmployeeDTOs();
	
	//findAllProjectedBy() added as part of instructions by Excercise 8 to define interface based projections
	List<EmployeeProjection> findAllProjectedBy();
		
	// Custom query to find employees by name using @Query added as part of Excercise 5 requirements
	//@Query queries are added as part of Exercise 5 instructions
    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> findEmployeesByName(@Param("name") String name);

    // Custom query to find employees by email using @Query added as part of Excercise 5 requirements
    //@Query queries are added as part of Exercise 5 instructions
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findEmployeeByEmail(@Param("email") String email);

    // Custom query to find employees by department name using @Query added as part of Excercise 5 requirements
    //@Query queries are added as part of Exercise 5 instructions	
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);
    
    // Derived query method to find employees by name with pagination and sorting added as part of Excercise 6 requirements
    Page<Employee> findByName(String name, Pageable pageable);

    // Derived query method to find employees by department name with pagination and sorting added as part of Excercise 6 requirements
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);
}
