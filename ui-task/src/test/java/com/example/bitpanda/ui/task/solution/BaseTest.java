package com.example.bitpanda.ui.task.solution;

import com.example.bitpanda.ui.task.solution.config.ResourceReader;
import com.example.bitpanda.ui.task.solution.data.TestProduct;
import com.example.bitpanda.ui.task.solution.pages.HomePage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeGroups;

public class BaseTest {
    protected TestProduct blouseProduct;
    protected final HomePage homePage = new HomePage();

    @BeforeGroups({"checkout", "modalTests"})
    public void setupTests() {
        prepareTest();
    }

    @SneakyThrows
    protected void prepareTest() {
        homePage.openPage();
        ObjectMapper objectMapper = new ObjectMapper();
        blouseProduct = objectMapper.readValue(ResourceReader.loadFileFromTestResources(BaseTest.class, "blouse_product.json"),
                TestProduct.class);
    }
}
