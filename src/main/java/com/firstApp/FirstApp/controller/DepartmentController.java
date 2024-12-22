package com.firstApp.FirstApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstApp.FirstApp.entity.Department;
import com.firstApp.FirstApp.services.DepartmentService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class DepartmentController  {
    @Autowired private DepartmentService departmentService; 
     // Save operation

    @PostMapping("/departments") 
    public Department saveDepartment(@Validated @RequestBody Department department)
    {
        int c = multiply(10, 20);
        return departmentService.saveDepartment(department);
    }

    public int multiply(int a,int b){
        return a*b;
    }
    @GetMapping("/departments") 
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/departments/{id}") 
    public Department
    updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(department, departmentId);
    }

     @DeleteMapping("/departments/{id}") 
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
    {
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully";
    }
}
