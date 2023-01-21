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

    public List<Office> getOffices() throws IOException {
        String office1 = "{\"street\":\"502 S Sharp St\",\"city\":\"Baltimore\",\"state\":\"MD\",\"zip\":21201}";
        String office2 = "{\"street\":\"5619 DTC Parkway, Suite 900\",\"city\":\"Englewood\",\"state\":\"CO\",\"zip\":80111}";

        Moshi moshi = new Moshi.Builder()
                .add(Date.class, new Rfc3339DateJsonAdapter())
                .build();
        JsonAdapter<Office> jsonAdapter = moshi.adapter(Office.class);

        List<Office> officeList = new ArrayList<>();

        officeList.add(jsonAdapter.fromJson(office1));
        officeList.add(jsonAdapter.fromJson(office2));

        return officeList;
    }
}
