package com.example.bitpanda.ui.task.solution.pages.sections.checkout.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.pages.LoginPage;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SummarySection {
    private final By productAvailabilityPath = Selectors.byXpath("./following-sibling::td[@class='cart_avail']/span");
    private final By proceedToCheckoutButtonPath = Selectors.byXpath("//p[@class='cart_navigation clearfix']/child::a[@title='Proceed to checkout']");

    @Step("Checking if product image is visible")
    public SummarySection checkIfProductImageIsVisible(String productName) {
        findProductImage(productName).shouldBe(Condition.visible);
        return this;
    }


    @Step("Checking availability of a product")
    public SummarySection checkAvailabilityOfAProduct(String productName, String expectedAvailability) {
        findProductAvailability(productName).shouldBe(Condition.visible)
                .shouldHave(Condition.ownText(expectedAvailability));
        return this;
    }

    @Step("Processing further in checkout process")
    public LoginPage proceedFurtherToCheckout() {
        ElementActions.clickOnClickableElement(findProceedToCheckoutButton());
        return new LoginPage();
    }

    @Step("Finding process to checkout button")
    private SelenideElement findProceedToCheckoutButton() {
        return ElementFinder.findActiveElement.apply(proceedToCheckoutButtonPath);
    }

    @Step("Finding product availability")
    private SelenideElement findProductAvailability(String productName) {
        return ElementFinder.findNestedReadableElement.apply(findProductDescription(productName), productAvailabilityPath);
    }

    @Step("Finding product description")
    private SelenideElement findProductDescription(String productName) {
        return ElementFinder.findExistingElement.apply(buildPathToProductDescription(productName));
    }

    @Step("Finding product image")
    private SelenideElement findProductImage(String productName) {
        return ElementFinder.findExistingElement.apply(buildPathToProductImage(productName));
    }

    private By buildPathToProductImage(String productName) {
        return Selectors.byXpath("//td[@class='cart_product']/descendant::img[@alt='" + productName + "']");
    }

    private By buildPathToProductDescription(String productName) {
        return Selectors.byXpath("//td[@class='cart_description' and contains(string(), '" + productName + "')]");
    }

}
