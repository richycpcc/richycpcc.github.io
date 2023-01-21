package io.catalyte;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import io.catalyte.application.EmployeeServiceImpl;
import io.catalyte.application.OfficeServiceImpl;
import io.catalyte.data.EmployeeCsvData;
import io.catalyte.data.EmployeeXmlData;
import io.catalyte.data.OfficeData;
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

        employeeController.start();

        employeeServiceImpl.setEmployeeDao(employeeXmlData);

        employeeController.start();

        OfficeController officeController = new OfficeController();
        OfficeServiceImpl officeServiceImpl = new OfficeServiceImpl();
        OfficeData officeData = new OfficeData();

        officeController.setOfficeService(officeServiceImpl);
        officeServiceImpl.setOfficeDao(officeData);

        officeController.start();



    }
}
