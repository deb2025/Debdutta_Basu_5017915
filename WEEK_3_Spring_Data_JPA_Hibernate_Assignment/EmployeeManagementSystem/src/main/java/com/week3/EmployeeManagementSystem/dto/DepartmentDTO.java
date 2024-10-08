package com.week3.EmployeeManagementSystem.dto;


//EmployeeDTO added as part of instructions from Excercise 8 as class based projections
public class DepartmentDTO {
    private Long id;
    private String name;

    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
    
    
}

