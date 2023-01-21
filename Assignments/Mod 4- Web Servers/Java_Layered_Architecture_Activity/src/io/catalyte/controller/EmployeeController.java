package io.catalyte.controller;

import io.catalyte.service.EmployeeService;
public class EmployeeController
{
    public EmployeeService employeeService;
    public void setEmployeeService(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }
    public void start() { employeeService.getEmployees();}

}
