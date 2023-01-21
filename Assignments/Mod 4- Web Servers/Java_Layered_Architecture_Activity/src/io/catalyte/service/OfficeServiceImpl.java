package io.catalyte.service;

import io.catalyte.dao.OfficeDao;

public class OfficeServiceImpl implements OfficeService
{
    public OfficeDao officeDao;
    public void setOfficeDao(OfficeDao officeDao)
    {
        this.officeDao = officeDao;
    }

    public void getOffices()
    {
        officeDao.getOffices();
    }
}
