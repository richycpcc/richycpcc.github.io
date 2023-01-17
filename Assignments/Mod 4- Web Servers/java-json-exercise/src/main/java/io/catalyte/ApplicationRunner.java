package io.catalyte;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import io.catalyte.application.EmployeeServiceImpl;
import io.catalyte.application.OfficeServiceImpl;
import io.catalyte.data.EmployeeCsvData;
import io.catalyte.data.EmployeeXmlData;
import io.catalyte.data.OfficeData;
import io.catalyte.entity.Employee;
import io.catalyte.entity.Office;
import io.catalyte.presentation.EmployeeController;
import io.catalyte.presentation.OfficeController;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ApplicationRunner {

    public static void main(String[] args) throws IOException {
        EmployeeController employeeController = new EmployeeController();
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        EmployeeCsvData employeeCsvData = new EmployeeCsvData();
        EmployeeXmlData employeeXmlData = new EmployeeXmlData();

        employeeController.setEmployeeService(employeeServiceImpl);
        employeeServiceImpl.setEmployeeDao(employeeCsvData);

        List<Employee> employees =  employeeController.getEmployees();

        // initialize json adapter
        Moshi moshi = new Moshi.Builder()
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .build();
        JsonAdapter<Employee> jsonEmployee = moshi.adapter(Employee.class);

        // loop through employees and write each out to the console
        for (Employee emp:employees) {
            System.out.println(jsonEmployee.toJson(emp));
        }

        OfficeController officeControllerImpl = new OfficeController();
        OfficeServiceImpl officeServiceImpl = new OfficeServiceImpl();
        OfficeData officeData = new OfficeData();

        officeControllerImpl.setOfficeService(officeServiceImpl);
        officeServiceImpl.setOfficeDao(officeData);

        List<Office> officeList = officeControllerImpl.getOffices();

        JsonAdapter<Office> jsonOffice = moshi.adapter(Office.class);

        // loop through offices and write each out to the console
        for (Office office:officeList) {
            System.out.println(jsonOffice.toJson(office));
        }

    }
}
