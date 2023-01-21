package io.catalyte.service;

import io.catalyte.dao.EmployeeDao;
import io.catalyte.entity.Employee;

import java.io.IOException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeDao employeeDao;
    public void setEmployeeDao (EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }
    /* took out for some reason
    public void getEmployees(){employeeDao.getEmployees();}
    */
    public List<Employee> getEmployees() throws IOException
    {
        return employeeDao.getEmployees();
    }

}
