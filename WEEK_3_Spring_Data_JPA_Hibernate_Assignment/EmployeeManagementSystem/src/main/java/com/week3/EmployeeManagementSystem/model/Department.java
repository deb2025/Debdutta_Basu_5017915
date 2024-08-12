package com.week3.EmployeeManagementSystem.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Hibernate-specific annotations to customize entity mappings as instructed in Excercise 10
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

// Department Entities added as part of Excercise 2 requirements 
@Entity
@Table(name = "departments")
//Added as part of instructions and requirements in Excercise 7 
@EntityListeners(AuditingEntityListener.class)

//Department Class added as JPA entity as of Excercise 2 instructions
public class Department {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//id added as of Excercise 2 requirements
    private Long id;

    @Column(nullable = false, unique = true)
    //name added as of Excercise 2 requirements
    private String name;

    //@OneToMany relationship added as part of instruction in Excercise 2 between Department and Employee
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
    
    //@CreatedBy annotation added as required by Excercise 7
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    //@CreatedDate added as required by Excercise 7
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    //@LastMOdifiedBy annotation added as required by Excercise 7
    @LastModifiedBy
    private String lastModifiedBy;

    //@LastMOdifiedBy annotation added as required by Excercise 7
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
    
    
}
