package io.catalyte.data;

import io.catalyte.entity.Employee;

import java.util.List;

public class EmployeeCsvData implements EmployeeDao {


    public List<Employee> getEmployees() {
        System.out.println("CSV DATA");

        return null;
    }
}
