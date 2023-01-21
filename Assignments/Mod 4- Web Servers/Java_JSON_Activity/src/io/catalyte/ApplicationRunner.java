package io.catalyte;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.JsonAdapter;

import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import io.catalyte.controller.EmployeeController;
import io.catalyte.controller.OfficeController;
import io.catalyte.dao.EmployeeCsvData;
import io.catalyte.dao.OfficeData;
import io.catalyte.entity.Employee;
import io.catalyte.entity.Office;
import io.catalyte.service.EmployeeServiceImpl;
import io.catalyte.service.OfficeServiceImpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ApplicationRunner
{
    public static void main(String[] args) throws IOException
    {
        EmployeeController employeeController = new EmployeeController();
        EmployeeCsvData employeeCsvData = new EmployeeCsvData();

        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

        OfficeController officeController = new OfficeController();
        OfficeData officeData = new OfficeData();
        OfficeServiceImpl officeServiceImpl = new OfficeServiceImpl();




        employeeController.setEmployeeService(employeeServiceImpl);
        employeeServiceImpl.setEmployeeDao(employeeCsvData);

        List<Employee> employees = employeeController.getEmployees();

        //initialize json adapter
        Moshi moshi = new Moshi.Builder()
                //.add(Date.class, new Rfc3339DateJsonAdapter())
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .build();
        JsonAdapter<Employee> jsonEmployee = moshi.adapter(Employee.class);

        //Loop through employees and write each to console
        for (Employee emp:employees){
            System.out.println(jsonEmployee.toJson(emp));
        }


        officeController.setOfficeService(officeServiceImpl);
        officeServiceImpl.setOfficeDao((officeData));

        List<Office> officeList = officeController.getOffices();

    JsonAdapter<Office> jsonOffice = moshi.adapter(Office.class);

    //loop through Office list to appear on console
        for (Office office:officeList){
            System.out.println(jsonOffice.toJson(office));
    }


    }
}
