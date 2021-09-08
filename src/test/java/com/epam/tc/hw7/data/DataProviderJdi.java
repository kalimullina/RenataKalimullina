package com.epam.tc.hw7.data;

import com.epam.tc.hw7.entities.Data;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class DataProviderJdi {

    @DataProvider(name = "jsonData")
    public static Object[][] getJson() throws FileNotFoundException {

        final String jsonPath = "src/test/resources/hw7/JDI_ex8_metalsColorsDataSet.json";
        Gson g = new Gson();
        BufferedReader jsonString = new BufferedReader(new FileReader(jsonPath));
        Type dataMapType = new TypeToken<Map<String, Data>>(){}.getType();
        Map<String, Data> dataFromJson = g.fromJson(jsonString, dataMapType);

        Object[][] mapObject = new Object[dataFromJson.size()][1];
        int dataNumber = 1;
        for (int i = 0; i < dataFromJson.size(); i++) {
            mapObject[i][0] = dataFromJson.get("data_" + dataNumber);
            dataNumber++;
        }
        return mapObject;
    }
}
