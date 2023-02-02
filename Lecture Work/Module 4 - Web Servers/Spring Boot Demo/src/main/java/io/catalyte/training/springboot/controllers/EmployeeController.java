package io.catalyte.training.springboot.controllers;

import io.catalyte.training.springboot.customexceptions.EmployeeNotFound;
import io.catalyte.training.springboot.entities.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    //Initializing things
    private List<Employee> employees = new ArrayList<>();
    private int autoNumber = 0;

    //create new employee
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee)
    {
        autoNumber++;
        employee.setEmployeeId(autoNumber);
        employees.add(employee);
        System.out.println(employees.size() + "employees.");
        return employee;
    }

    //get a list of all employees
    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployees()
    {
        return employees;
    }

    //search employee by id
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public Employee getEmployeeById (@PathVariable int employeeId)
    {
        for(Employee e: employees)
        {
            if(e.getEmployeeId()!= null && e.getEmployeeId() == employeeId)
            {
                return e;
            }
        }
        throw new EmployeeNotFound();
    }

    //delete employee record by id
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
    public void deleteEmployee (@PathVariable  int employeeId)
    {
        for(Employee e:employees)
        {
            if(e.getEmployeeId() != null && e.getEmployeeId() == employeeId)
            {
                employees.remove(e);
                return;
            }
        }
    throw new EmployeeNotFound();
    }

    //search by employeeId
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
    public Employee updateEmployee (@PathVariable int employeeId, @RequestBody Employee employee)
    {
        for(Employee e:employees)
        {
            if(e.getEmployeeId() != null && e.getEmployeeId() == employeeId)
            {
                int index = employees.indexOf(e);
                employees.set(index, employee);
                return employee;
            } // end if
        } // end for
        throw new EmployeeNotFound();
    } // end method

    @RequestMapping(method = RequestMethod.GET, params = "isActive")
    public List<Employee> getActiveEmployee(@RequestParam() Boolean isActive)
    {
        List<Employee> activeEmployees = new ArrayList<>();

        for(Employee e: employees)
        {
            if(e.getActive() == true)
            {
                activeEmployees.add(e);
            }

        }
        return activeEmployees;

    }


}//end class
