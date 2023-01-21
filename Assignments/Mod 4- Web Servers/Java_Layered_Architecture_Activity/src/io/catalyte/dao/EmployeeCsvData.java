package io.catalyte.dao;

import java.util.List;
import io.catalyte.entity.Employee;

public class EmployeeCsvData implements EmployeeDao
{
    public List<Employee> getEmployees()
    {
            System.out.println("CSV data");
            return null;
    }
}
