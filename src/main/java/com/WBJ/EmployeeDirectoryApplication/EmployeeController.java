package com.WBJ.EmployeeDirectoryApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/employees")

//@CrossOrigin(origins = "http://localhost:5173")

public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee>getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping ("/{id}")
    public Employee getEmployeeById (@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee (@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee (@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
         return service.saveEmployee(employee);
    }

    @DeleteMapping ("/{id}")
    public void deleteEmployee (@PathVariable Long id) {
        service.deleteEmployee( id);
    }
}
