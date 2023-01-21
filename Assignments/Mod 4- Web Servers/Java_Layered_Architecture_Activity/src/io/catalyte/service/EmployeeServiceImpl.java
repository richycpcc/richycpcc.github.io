package io.catalyte.service;

import io.catalyte.dao.EmployeeDao;


public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeDao employeeDao;
    public void setEmployeeDao (EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }
    public void getEmployees()
    {
        employeeDao.getEmployees();
    }
}
