package io.catalyte.dao;

import io.catalyte.entity.Office;
import java.util.List;

public class OfficeData implements OfficeDao
{
    public List<Office>getOffices()
    {
        System.out.println("Office Data");
        return null;
    }
}
