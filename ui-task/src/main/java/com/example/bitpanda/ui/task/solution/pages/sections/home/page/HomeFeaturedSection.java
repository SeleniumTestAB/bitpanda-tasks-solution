package com.example.bitpanda.ui.task.solution.pages.sections.home.page;

import com.codeborne.selenide.Selectors;
import com.example.bitpanda.ui.task.solution.pages.sections.items.HomeFeaturedItem;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomeFeaturedSection {
    private final By homeFeaturedSectionPath = Selectors.byXpath("//ul[@id='homefeatured']");

    @Step("Scrolling to featured products section")
    public HomeFeaturedSection scrollToSection() {
        ElementFinder.findExistingElement.apply(homeFeaturedSectionPath).scrollTo();
        return this;
    }

    public HomeFeaturedItem getItem(String itemName) {
        return new HomeFeaturedItem(homeFeaturedSectionPath, itemName);
    }
}
