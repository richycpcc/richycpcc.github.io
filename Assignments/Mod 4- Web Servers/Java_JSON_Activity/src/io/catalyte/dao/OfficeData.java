package io.catalyte.dao;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import com.squareup.moshi.JsonAdapter;
import io.catalyte.entity.Office;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class OfficeData implements OfficeDao
{
    public List<Office>getOffices() throws IOException
    {
        String office1 = "{\"street\":\"502 S Sharp St\",\"city\":\"Baltimore\",\"state\":\"MD\",\"zip\":21201}";
        String office2 = "{\"street\":\"5619 DTC Parkway, Suite 900\",\"city\":\"Englewood\",\"state\":\"CO\",\"zip\":80111}";

        //initialize json adapter
        Moshi moshi = new Moshi.Builder()
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .build();
        JsonAdapter<Office> jsonAdapter = moshi.adapter(Office.class);

        //create return list
        List<Office> officeList= new ArrayList<>();

        //convert office to objects and add to console
        officeList.add(jsonAdapter.fromJson(office1));
        officeList.add(jsonAdapter.fromJson(office2));

        return officeList;
    }
}
