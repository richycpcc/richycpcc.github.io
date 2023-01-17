package io.catalyte.data;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import io.catalyte.entity.Office;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfficeData implements OfficeDao {

    public List<Office> getOffices()  {
        System.out.println("OFFICE DATA");

        return null;
    }
}
