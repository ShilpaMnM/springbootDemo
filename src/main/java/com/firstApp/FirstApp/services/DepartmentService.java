package com.firstApp.FirstApp.services;

import java.util.List;

import com.firstApp.FirstApp.entity.Department;

public interface DepartmentService {
    
     // Save operation
    Department saveDepartment(Department department);
 
    // Read operation
    List<Department> fetchDepartmentList();
 
    // Update operation
    Department updateDepartment(Department department,
    Long departmentId);
 
    // Delete operation
    void deleteDepartmentById(Long departmentId);
}
