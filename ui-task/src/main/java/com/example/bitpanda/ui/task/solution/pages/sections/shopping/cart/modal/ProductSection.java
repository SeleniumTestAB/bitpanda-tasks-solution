package com.example.bitpanda.ui.task.solution.pages.sections.shopping.cart.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductSection extends BaseSection {
    private final By addedProductPricePath = Selectors.byId("layer_cart_product_price");
    private final By addedProductQuantityPath = Selectors.byId("layer_cart_product_quantity");
    private final By addedProductNamePath = Selectors.byId("layer_cart_product_title");
    private final By addedProductAttributesPath = Selectors.byId("layer_cart_product_attributes");

    @Step("Checking that added product price is visible")
    public ProductSection checkAddedProductPriceIsVisible(){
        findAddedProductPrice().shouldBe(Condition.visible);
        findFieldLabel(findAddedProductPrice()).shouldBe(Condition.visible);
        return this;
    }
    @Step("Checking that added product quantity is visible")
    public ProductSection checkAddedProductQuantityIsVisible(){
        findAddedProductQuantity().shouldBe(Condition.visible);
        findFieldLabel(findAddedProductQuantity()).shouldBe(Condition.visible);
        return this;
    }
    @Step("Checking that added product attributes are visible")
    public ProductSection checkAddedProductAttributesAreVisible(){
        findProductAttributes().shouldBe(Condition.visible);

        return this;
    }
    @Step("Checking that added product name is visible")
    public ProductSection checkAddedProductNameIsVisible(){
        findAddedProductName().shouldBe(Condition.visible);
        return this;
    }
    @Step("Checking label for added product price")
    public ProductSection checkAddedProductPriceLabel(String expectedLabel) {
        findFieldLabel(findAddedProductPrice()).shouldHave(Condition.ownText(expectedLabel));
        return this;
    }

    @Step("Checking label for added product quantity")
    public ProductSection checkAddedProductQuantityLabel(String expectedLabel) {
        findFieldLabel(findAddedProductQuantity()).shouldHave(Condition.ownText(expectedLabel));
        return this;
    }
    @Step("Checking added product price")
    public ProductSection checkAddedProductPrice(String expectedPrice) {
        findAddedProductPrice().shouldHave(Condition.ownText(expectedPrice));
        return this;
    }
    @Step("Checking added product quantity")
    public ProductSection checkQuantityOfAddedProducts(String expectedQuantity) {
        findAddedProductQuantity().shouldHave(Condition.ownText(expectedQuantity));
        return this;
    }
    @Step("Checking added product attributes")
    public ProductSection checkAddedProductAttributes(String... expectedAttributes) {
        String convertedExpectations = String.join(", ", expectedAttributes);
        findProductAttributes().shouldHave(Condition.ownText(convertedExpectations));
        return this;
    }

    @Step("Checking added product name")
    public ProductSection checkAddedProductName(String expectedName) {
        findAddedProductName().shouldHave(Condition.ownText(expectedName));
        return this;
    }

    @Step("Finding added product attributes")
    private SelenideElement findProductAttributes() {
        return ElementFinder.findExistingElement.apply(addedProductAttributesPath);
    }
    @Step("Finding added product quantity")
    private SelenideElement findAddedProductQuantity() {
        return ElementFinder.findExistingElement.apply(addedProductQuantityPath);
    }
    @Step("Finding added product price")
    private SelenideElement findAddedProductPrice() {
        return ElementFinder.findExistingElement.apply(addedProductPricePath);
    }

    @Step("Finding added product name")
    private SelenideElement findAddedProductName() {
        return ElementFinder.findExistingElement.apply(addedProductNamePath);
    }
}
