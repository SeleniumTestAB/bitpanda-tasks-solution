package com.example.bitpanda.ui.task.solution;

import com.example.bitpanda.ui.task.solution.pages.HomePage;
import org.testng.annotations.Test;

public class MainPageTest {
    @Test
    public void addProductToCard() {
        HomePage homePage = new HomePage();
        homePage.openPage();
        homePage.getHomeFeaturedSection()
                .scrollToSection()
                .getItem("Faded Short Sleeve T-shirts")
                .hoverOnImage()
                .addItemToCard()
                .modalShouldBeVisible();

    }
}