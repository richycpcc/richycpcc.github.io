package io.catalyte.presentation;

import io.catalyte.application.EmployeeService;

public class EmployeeController {

    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void start() {
        employeeService.getEmployees();
    }

}
