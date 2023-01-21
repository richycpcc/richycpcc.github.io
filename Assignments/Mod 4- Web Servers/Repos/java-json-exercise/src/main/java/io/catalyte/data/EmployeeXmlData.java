package io.catalyte.data;

import io.catalyte.entity.Employee;

import java.util.List;

public class EmployeeXmlData implements EmployeeDao {

    public List<Employee> getEmployees() {
        System.out.println("XML DATA");

        return null;
    }
}
