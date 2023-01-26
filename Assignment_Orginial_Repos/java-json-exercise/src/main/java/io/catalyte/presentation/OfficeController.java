package io.catalyte.presentation;

import io.catalyte.application.OfficeService;
import io.catalyte.entity.Office;

import java.io.IOException;
import java.util.List;

public class OfficeController {

    private OfficeService officeService;

    public void setOfficeService(OfficeService officeService) {
        this.officeService = officeService;
    }

    public List<Office> getOffices() throws IOException {
        return officeService.getOffices();
    }
}
