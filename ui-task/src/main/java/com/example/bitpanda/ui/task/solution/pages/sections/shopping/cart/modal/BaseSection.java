package com.example.bitpanda.ui.task.solution.pages.sections.shopping.cart.modal;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class BaseSection {
    private final By modalFieldLabelPath = Selectors.byXpath("./preceding-sibling::strong[@class='dark']");

    @Step("Finding field's label")
    protected SelenideElement findFieldLabel(SelenideElement givenField) {
        return ElementFinder.findNestedExistingElement.apply(givenField, modalFieldLabelPath);
    }
}
