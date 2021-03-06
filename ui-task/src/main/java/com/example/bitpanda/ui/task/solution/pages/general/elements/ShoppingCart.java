package com.example.bitpanda.ui.task.solution.pages.general.elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ShoppingCart {
    private final By viewShoppingCartPath = Selectors.byTitle("View my shopping cart");

    @Step("Viewing shopping cart")
    public ShoppingCart viewShoppingCart() {
        findViewMyShoppingCart().scrollTo();
        findViewMyShoppingCart().hover();
        return this;
    }

    @Step("Removing product from the cart")
    public ShoppingCart removeProductFromTheCart(String givenProduct) {
        findRemoveItemButton(givenProduct).click();
        return this;
    }

    @Step("Finding remove button for given product")
    private SelenideElement findRemoveItemButton(String givenItem) {
        return ElementFinder.findExistingElement.apply(buildPathToRemoveItemButton(givenItem));
    }

    @Step("Finding view my shopping cart")
    private SelenideElement findViewMyShoppingCart() {
        return ElementFinder.findActiveElement.apply(viewShoppingCartPath);
    }

    private By buildPathToRemoveItemButton(String givenItem) {
        return Selectors.byXpath("//a[@title='"+givenItem+"']/following-sibling::span[@class='remove_link']/child::a[@class='ajax_cart_block_remove_link']");
    }

}
