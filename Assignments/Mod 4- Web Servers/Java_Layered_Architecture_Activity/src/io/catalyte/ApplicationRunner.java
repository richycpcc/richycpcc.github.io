package io.catalyte;

import io.catalyte.controller.EmployeeController;
import io.catalyte.controller.OfficeController;
import io.catalyte.dao.EmployeeCsvData;
import io.catalyte.dao.EmployeeXmlData;
import io.catalyte.dao.OfficeDao;
import io.catalyte.dao.OfficeData;
import io.catalyte.entity.Employee;
import io.catalyte.service.EmployeeServiceImpl;
import io.catalyte.service.OfficeServiceImpl;

public class ApplicationRunner
{
    public static void main(String[] args)
    {
        EmployeeController employeeController = new EmployeeController();
        EmployeeCsvData employeeCsvData = new EmployeeCsvData();
        EmployeeXmlData employeeXmlData = new EmployeeXmlData();
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

        OfficeController officeController = new OfficeController();
        OfficeData officeData = new OfficeData();
        OfficeServiceImpl officeServiceImpl = new OfficeServiceImpl();

        employeeController.setEmployeeService(employeeServiceImpl);
        officeController.setOfficeService(officeServiceImpl);

        employeeServiceImpl.setEmployeeDao(employeeCsvData);
        employeeController.start();

        employeeServiceImpl.setEmployeeDao(employeeXmlData);
        employeeController.start();

        officeServiceImpl.setOfficeDao(officeData);
        officeController.start();


    }
}
