package io.catalyte.dao;
import io.catalyte.entity.Employee;
import java.util.List;
public class EmployeeXmlData implements EmployeeDao
{
    public List<Employee> getEmployees()
    {
        System.out.println("XML data");
        return null;
    }
}
