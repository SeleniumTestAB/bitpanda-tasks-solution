package com.example.bitpanda.ui.task.solution.pages;


import com.codeborne.selenide.Selenide;
import com.example.bitpanda.ui.task.solution.pages.general.elements.ShoppingCart;
import com.example.bitpanda.ui.task.solution.pages.sections.home.page.HomeFeaturedSection;
import lombok.Getter;

public class HomePage {
    @Getter
    private final HomeFeaturedSection homeFeaturedSection = new HomeFeaturedSection();
    @Getter
    private final ShoppingCart shoppingCart = new ShoppingCart();


    public HomePage openPage() {
        Selenide.open("http://automationpractice.com/index.php");
        return this;
    }
}