package io.catalyte.service;

import io.catalyte.entity.Office;

import java.io.IOException;
import java.util.List;

public interface OfficeService
{
    List<Office> getOffices() throws IOException;
}
