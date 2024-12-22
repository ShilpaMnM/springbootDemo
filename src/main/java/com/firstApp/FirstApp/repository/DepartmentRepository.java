package com.firstApp.FirstApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.firstApp.FirstApp.entity.Department;

@Repository

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    
}
