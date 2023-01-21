package io.catalyte.controller;

import io.catalyte.service.EmployeeService;
import io.catalyte.entity.Employee;

import java.io.IOException;
import java.util.List;

public class EmployeeController
{
    public EmployeeService employeeService;
    public void setEmployeeService(EmployeeService employeeService) {this.employeeService = employeeService;}

   public List<Employee> getEmployees() throws IOException{
        return employeeService.getEmployees();
   }
}
