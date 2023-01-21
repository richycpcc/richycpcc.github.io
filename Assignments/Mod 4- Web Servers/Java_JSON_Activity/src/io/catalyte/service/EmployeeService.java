package io.catalyte.service;

import io.catalyte.entity.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeService
{
    List<Employee> getEmployees() throws IOException;
}
