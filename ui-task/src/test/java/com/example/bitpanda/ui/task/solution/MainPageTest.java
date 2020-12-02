package com.example.bitpanda.ui.task.solution;

import com.example.bitpanda.ui.task.solution.pages.HomePage;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest{
    @Test
    public void addProductToCard() {

        homePage.openPage();
        homePage.getHomeFeaturedSection()
                .scrollToSection()
                .getItem("Faded Short Sleeve T-shirts")
                .hoverOnImage()
                .addItemToCard()
                .modalShouldBeVisible();

    }
}