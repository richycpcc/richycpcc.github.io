package io.catalyte.application;

import io.catalyte.data.EmployeeDao;
import io.catalyte.entity.Employee;

import java.io.IOException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getEmployees() throws IOException {
        return employeeDao.getEmployees();
    }
}