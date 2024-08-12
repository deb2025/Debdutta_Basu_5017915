package com.week3.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.week3.EmployeeManagementSystem.model.Employee;
import com.week3.EmployeeManagementSystem.repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//EmployeeService added as part of Implement batch processing in a service method instructions as instructed by Excercise 10
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void bulkInsertEmployees(List<Employee> employees) {
        int batchSize = 20;
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                // Flush a batch of inserts and release memory
                entityManager.flush();
                entityManager.clear();
            }
        }
        // Ensure the remaining entities are flushed and cleared
        entityManager.flush();
        entityManager.clear();
    }
}
