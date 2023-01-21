package io.catalyte.dao;

import java.io.IOException;
import java.util.List;
import io.catalyte.entity.Office;
public interface OfficeDao
{
    List<Office>getOffices() throws IOException;
}
