package io.catalyte.application;


import io.catalyte.data.OfficeDao;
import io.catalyte.entity.Office;

import java.io.IOException;
import java.util.List;

public class OfficeServiceImpl implements OfficeService {
    private OfficeDao officeDao;

    public void setOfficeDao(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }

    public void getOffices() { officeDao.getOffices(); }

}
