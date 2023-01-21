package io.catalyte.presentation;

import io.catalyte.application.EmployeeService;
import io.catalyte.entity.Employee;

import java.io.IOException;
import java.util.List;

public class EmployeeController {

    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployees() throws IOException {
        return employeeService.getEmployees();
    }
}
