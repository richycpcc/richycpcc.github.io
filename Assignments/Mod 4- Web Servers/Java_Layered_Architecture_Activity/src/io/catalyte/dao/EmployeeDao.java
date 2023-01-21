package io.catalyte.dao;

import io.catalyte.entity.Employee;
import java.util.List;

public interface EmployeeDao {
    List<Employee> getEmployees();
}
