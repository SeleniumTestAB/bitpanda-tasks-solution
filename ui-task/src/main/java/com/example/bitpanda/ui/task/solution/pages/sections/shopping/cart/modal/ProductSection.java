package com.example.bitpanda.ui.task.solution.pages.sections.shopping.cart.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import org.openqa.selenium.By;

public class ProductSection extends BaseSection {
    private final By addedProductPricePath = Selectors.byId("layer_cart_product_price");
    private final By addedProductQuantityPath = Selectors.byId("layer_cart_product_quantity");
    private final By addedProductNamePath = Selectors.byId("layer_cart_product_title");
    private final By addedProductAttributesPath = Selectors.byId("layer_cart_product_attributes");


    public ProductSection checkAddedProductPriceIsVisible(){
        findAddedProductPrice().shouldBe(Condition.visible);
        findFieldLabel(findAddedProductPrice()).shouldBe(Condition.visible);
        return this;
    }

    public ProductSection checkAddedProductQuantityIsVisible(){
        findAddedProductQuantity().shouldBe(Condition.visible);
        findFieldLabel(findAddedProductQuantity()).shouldBe(Condition.visible);
        return this;
    }

    public ProductSection checkAddedProductAttributesAreVisible(){
        findProductAttributes().shouldBe(Condition.visible);

        return this;
    }

    public ProductSection checkAddedProductNameIsVisible(){
        findAddedProductName().shouldBe(Condition.visible);
        return this;
    }

    public ProductSection checkAddedProductPriceLabel(String expectedLabel) {
        findFieldLabel(findAddedProductPrice()).shouldHave(Condition.ownText(expectedLabel));
        return this;
    }


    public ProductSection checkAddedProductQuantityLabel(String expectedLabel) {
        findFieldLabel(findAddedProductQuantity()).shouldHave(Condition.ownText(expectedLabel));
        return this;
    }

    public ProductSection checkAddedProductPrice(String expectedPrice) {
        findAddedProductPrice().shouldHave(Condition.ownText(expectedPrice));
        return this;
    }

    public ProductSection checkQuantityOfAddedProducts(String expectedQuantity) {
        findAddedProductQuantity().shouldHave(Condition.ownText(expectedQuantity));
        return this;
    }

    public ProductSection checkAddedProductAttributes(String... expectedAttributes) {
        String convertedExpectations = String.join(", ", expectedAttributes);
        findProductAttributes().shouldHave(Condition.ownText(convertedExpectations));
        return this;
    }

    public ProductSection checkAddedProductName(String expectedName) {
        findAddedProductName().shouldHave(Condition.ownText(expectedName));
        return this;
    }


    private SelenideElement findProductAttributes() {
        return ElementFinder.findExistingElement.apply(addedProductAttributesPath);
    }

    private SelenideElement findAddedProductQuantity() {
        return ElementFinder.findExistingElement.apply(addedProductQuantityPath);
    }

    private SelenideElement findAddedProductPrice() {
        return ElementFinder.findExistingElement.apply(addedProductPricePath);
    }

    private SelenideElement findAddedProductName() {
        return ElementFinder.findExistingElement.apply(addedProductNamePath);
    }
}
