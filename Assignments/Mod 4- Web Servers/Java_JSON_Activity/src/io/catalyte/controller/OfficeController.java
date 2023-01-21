package io.catalyte.controller;

import io.catalyte.entity.Employee;
import io.catalyte.entity.Office;
import io.catalyte.service.OfficeService;

import java.io.IOException;
import java.util.List;

public class OfficeController
{
    public OfficeService officeService;
    public void setOfficeService(OfficeService officeService)
    {
        this.officeService = officeService;
    }

    //public void start(){officeService.getOffices();}
    public List<Office> getOffices() throws IOException{
        return officeService.getOffices();
    }
}
