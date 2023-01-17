package io.catalyte.data;

import io.catalyte.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployees();
}
