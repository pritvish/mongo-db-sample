package org.blitz.mongodbsample.service;

import org.blitz.mongodbsample.document.EmployeeDocument;
import org.blitz.mongodbsample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // create
    public EmployeeDocument createEmployee(EmployeeDocument employeeDocument) {
        EmployeeDocument savedEmployeeDocument = employeeRepository.save(employeeDocument);
        return savedEmployeeDocument;
    }

    // findAll
    public List<EmployeeDocument> getAllEmployees() {
        List<EmployeeDocument> employeeDocuments = employeeRepository.findAll();
        return employeeDocuments;
    }

    // findById
    public EmployeeDocument getEmployeeById(String id) {
        EmployeeDocument employee = employeeRepository.getEmployeeByEmployeeId(id);
        return employee;
    }

    // update
    public EmployeeDocument updateEmployee(EmployeeDocument employeeDocument) {
        EmployeeDocument savedEmployeeDocument = null;
        if (null != employeeRepository.getEmployeeByEmployeeId(employeeDocument.getEmployeeId())) {
            savedEmployeeDocument = employeeRepository.save(employeeDocument);
        }
        return savedEmployeeDocument;
    }

    // delete
    public String deleteEmployee(String id) {
        employeeRepository.deleteById(id);
        return "employee with id: " + id + " deleted successfully";
    }
}
