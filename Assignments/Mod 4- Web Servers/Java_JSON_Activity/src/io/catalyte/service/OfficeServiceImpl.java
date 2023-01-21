package io.catalyte.service;

import io.catalyte.dao.OfficeDao;
import io.catalyte.entity.Employee;
import io.catalyte.entity.Office;
import java.util.List;
import java.io.IOException;

import java.io.IOException;

public class OfficeServiceImpl implements OfficeService
{
    public OfficeDao officeDao;
    public void setOfficeDao(OfficeDao officeDao)
    {
        this.officeDao = officeDao;
    }

    public List<Office> getOffices() throws IOException{
        return officeDao.getOffices();
    }
}
