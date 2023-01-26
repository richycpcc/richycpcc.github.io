package io.catalyte.data;

import io.catalyte.entity.Office;

import java.io.IOException;
import java.util.List;

public interface OfficeDao {
    List<Office> getOffices();
}
