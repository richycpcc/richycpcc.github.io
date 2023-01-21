package io.catalyte.controller;

import io.catalyte.service.OfficeService;
public class OfficeController
{
    public OfficeService officeService;
    public void setOfficeService(OfficeService officeService)
    {
        this.officeService = officeService;
    }

    public void start(){officeService.getOffices();}
}
