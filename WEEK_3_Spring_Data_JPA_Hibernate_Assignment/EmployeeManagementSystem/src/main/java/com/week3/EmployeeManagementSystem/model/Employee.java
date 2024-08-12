package com.week3.EmployeeManagementSystem.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


//Hibernate-specific annotations to customize entity mappings as instructed in Excercise 10
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)


//Employee Entities added as part of Excercise 2 requirements
@Entity
@Table(name = "employees")


//Added as part of instructions and requirements in Excercise 7 
@EntityListeners(AuditingEntityListener.class)


//@NamedQueries added as part of Excercise 5 requirements
@NamedQueries({
    @NamedQuery(
        name = "Employee.findByName",
        query = "SELECT e FROM Employee e WHERE e.name = :name"
    ),
    @NamedQuery(
        name = "Employee.findByEmail",
        query = "SELECT e FROM Employee e WHERE e.email = :email"
    )
})


//Employee Class added as JPA entity as of Excercise 2 instructions
//@Entity, @Table, @Id, @GeneratedValue are used as of Excercise 2 requirements
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	//id added as of Excercise 2 requirements
    private Long id;

    @Column(nullable = false)
    //name added as of Excercise 2 requirements
    private String name;

    
    //Hibernate-specific annotation for custom column definition is added as required by excercise 10
    @Column(name = "email", unique = true, nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'UNKNOWN'")
    //email added as of Excercise 2 requirements
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    //department added as of Excercise 2 requirements
    private Department department;
    
    //@CreatedBy annotation added as required by Excercise 7
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    //@CreatedDate annotation added as required by Excercise 7
    @CreatedDate
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    //@LastModifiedBy annotation added as required by Excercise 7
    @LastModifiedBy
    private String lastModifiedBy;

    //@LastModifiedBy annotation added as required by Excercise 7
    @LastModifiedDate
    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

    // Getters and setters for all the fields listed above
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
