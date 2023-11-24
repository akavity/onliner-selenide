package org.example.utils;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.example.models.MobileData;
import org.example.models.TopNavigationData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    @DataProvider(name = "topNavigationData")
    public Object[][] getNavigationData() throws IOException {
        String filePath = "src/test/resources/test-data/topNavigationData.json";
        List<TopNavigationData> dataList = readTestDataFromJson(filePath);

        Object[][] data = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }

        return data;
    }

    private List<TopNavigationData> readTestDataFromJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return mapper.readValue(fis, new TypeReference<>() {
            });
        }
    }

    @DataProvider(name = "mobileData")
    public Object[][] getMobileData() throws IOException {
        String filePath = "src/test/resources/test-data/mobileData.json";
        List<MobileData> dataList = readMobileDataFromJson(filePath);

        Object[][] data = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }

        return data;
    }

    private List<MobileData> readMobileDataFromJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return mapper.readValue(fis, new TypeReference<>() {
            });
        }
    }
}
