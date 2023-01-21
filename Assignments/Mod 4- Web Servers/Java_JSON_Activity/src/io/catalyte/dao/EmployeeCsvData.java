package io.catalyte.dao;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import io.catalyte.entity.Employee;

public class EmployeeCsvData implements EmployeeDao
{
    public List<Employee> getEmployees() throws IOException
    {
        //initialize employee as strings
        String employee1 = "{\"FirstName\":\"Dan\",\"HireDate\":\"2008-01-02T07:19:00.000Z\",\"LastName\":\"Lawless\"}";
        String employee2 = "{\"FirstName\":\"Chase\",\"HireDate\":\"2019-09-01T06:00:00.000Z\",\"LastName\":\"Dunton\"}";

        //initialize json adapter
        Moshi moshi = new Moshi.Builder()
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .build();
        JsonAdapter<Employee> jsonAdapter = moshi.adapter(Employee.class);

        //create return list
        List<Employee> employees = new ArrayList<>();

        //convert employees to objects and add to Array List
        employees.add(jsonAdapter.fromJson(employee1));
        employees.add(jsonAdapter.fromJson(employee2));


            return employees;
    }
}
