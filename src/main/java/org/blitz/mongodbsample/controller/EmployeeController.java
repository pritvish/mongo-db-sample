package org.blitz.mongodbsample.controller;

import org.blitz.mongodbsample.document.EmployeeDocument;
import org.blitz.mongodbsample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDocument>> getAllEmployees() {
        List<EmployeeDocument> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<List<EmployeeDocument>>(allEmployees, HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<EmployeeDocument> getEmployeeById(@RequestParam String id) {
        EmployeeDocument employeeById = employeeService.getEmployeeById(id);
        return new ResponseEntity<EmployeeDocument>(employeeById, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDocument> getEmployeeById(@RequestBody EmployeeDocument employeeDocument) {
        EmployeeDocument employee = employeeService.createEmployee(employeeDocument);
        return new ResponseEntity<EmployeeDocument>(employee, HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<EmployeeDocument> updateEmployee(@RequestBody EmployeeDocument employeeDocument) {
        EmployeeDocument employee = employeeService.updateEmployee(employeeDocument);
        return new ResponseEntity<EmployeeDocument>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/employee")
    public ResponseEntity<String> deleteEmployee(@RequestParam String id) {
        return new ResponseEntity<String>(employeeService.deleteEmployee(id),HttpStatus.OK);
    }

}
