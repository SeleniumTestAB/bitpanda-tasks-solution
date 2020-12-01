package com.example.bitpanda.ui.task.solution.pages.modals;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import org.openqa.selenium.By;

public class ShoppingCardModal {
    private final By modalRootPath = Selectors.byXpath("//div[@id='layer_cart']");
    private final By modalTitlePath = Selectors.byXpath(".//descendant::i/parent::h2");

    public ShoppingCardModal modalShouldBeVisible() {
        findModalRoot().shouldBe(Condition.visible);
        return this;
    }

    public ShoppingCardModal checkModalTitle(String expectedTitle) {
        findModalTitle().shouldHave(Condition.text(expectedTitle));
        return this;
    }

    private SelenideElement findModalTitle() {
        return ElementFinder.findNestedReadableElement
                .apply(findModalRoot(), modalTitlePath);
    }

    private SelenideElement findModalRoot() {
        return ElementFinder.findExistingElement.apply(modalRootPath);
    }
}
