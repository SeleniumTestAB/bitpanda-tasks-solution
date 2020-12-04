package com.example.bitpanda.ui.task.solution.pages.sections.shopping.cart.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ShoppingCartSection extends BaseSection {
    private final By totalProductsPriceInCardPath = Selectors.byXpath("//span[@class='ajax_block_products_total']");
    private final By totalShippingCostPath = Selectors.byXpath("//span[@class='ajax_cart_shipping_cost']");
    private final By totalShoppingCostPath = Selectors.byXpath("//span[@class='ajax_block_cart_total']");
    private final By shoppingCardStatusInfoPath = Selectors.byXpath("//span[@class='ajax_cart_product_txt' or contains(@class, 'ajax_cart_product_txt')]");
    private final By quantityOfProductsInShoppingCartPath = Selectors.byXpath("//span[@class='ajax_cart_quantity']");


    @Step("Checking that shopping cart status info is visible")
    public ShoppingCartSection checkShoppingCartStatusInfoIsVisible() {
        findShoppingCartStatusInfo().shouldBe(Condition.visible);
        return this;
    }

    @Step("Checking that shopping cost is visible")
    public ShoppingCartSection checkTotalShoppingCostIsVisible() {
        findTotalShoppingCost().shouldBe(Condition.visible);
        findFieldLabel(findTotalShoppingCost()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Checking that shipping cost is visible")
    public ShoppingCartSection checkTotalShippingCostIsVisible() {
        findTotalShippingCost().shouldBe(Condition.visible);
        findFieldLabel(findTotalShippingCost()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Checking that total price/cost of products in cart is visible")
    public ShoppingCartSection checkTotalProductsPriceInCardIsVisible() {
        findTotalProductsPriceInCard().shouldBe(Condition.visible);
        findFieldLabel(findTotalProductsPriceInCard()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Checking current shopping cart status information")
    public ShoppingCartSection checkShoppingCartStatusInfo(String expectedInfo, String expectedQuantity) {
        findShoppingCartStatusInfo().shouldHave(Condition.ownText(expectedInfo));
        findQuantityOfProductsInShoppingCart().shouldHave(Condition.ownText(expectedQuantity));
        return this;
    }

    @Step("Checking current shopping cart status information")
    public ShoppingCartSection checkShoppingCartStatusInfo(String expectedInfo) {
        findShoppingCartStatusInfo().shouldHave(Condition.ownText(expectedInfo));
        return this;
    }
    @Step("Checking label for total shopping cost")
    public ShoppingCartSection checkTotalShoppingCostLabel(String expectedLabel) {
        findFieldLabel(findTotalShoppingCost()).shouldHave(Condition.ownText(expectedLabel));
        return this;
    }

    @Step("Checking label for total shipping cost")
    public ShoppingCartSection checkTotalShippingCostLabel(String expectedLabel) {
        findFieldLabel(findTotalShippingCost()).shouldHave(Condition.ownText(expectedLabel));
        return this;
    }

    @Step("Checking label for total price/cost of products in shopping cart")
    public ShoppingCartSection checkTotalProductsPriceInCardLabel(String expectedLabel) {
        findFieldLabel(findTotalProductsPriceInCard()).shouldHave(Condition.ownText(expectedLabel));
        return this;
    }

    @Step("Checking total shopping cost")
    public ShoppingCartSection checkTotalShoppingCost(String expectedCost) {
        findTotalShoppingCost().shouldHave(Condition.ownText(expectedCost));
        return this;
    }
    @Step("Checking total shipping cost")
    public ShoppingCartSection checkTotalShippingCost(String expectedCost) {
        findTotalShippingCost().shouldHave(Condition.ownText(expectedCost));
        return this;
    }
    @Step("Checking total cost/price of products in shopping cart")
    public ShoppingCartSection checkTotalProductsCost(String expectedCost) {
        findTotalProductsPriceInCard().shouldHave(Condition.ownText(expectedCost));
        return this;
    }
    @Step("Finding total shopping cost")
    private SelenideElement findTotalShoppingCost() {
        return ElementFinder.findExistingElement.apply(totalShoppingCostPath);
    }
    @Step("Finding total shipping cost")
    private SelenideElement findTotalShippingCost() {
        return ElementFinder.findExistingElement.apply(totalShippingCostPath);
    }
    @Step("Finding total cost/price of products in shopping cart")
    private SelenideElement findTotalProductsPriceInCard() {
        return ElementFinder.findExistingElement.apply(totalProductsPriceInCardPath);
    }
    @Step("Finding quantity of products in shopping cart")
    private SelenideElement findQuantityOfProductsInShoppingCart() {
        return ElementFinder.findExistingElement.apply(quantityOfProductsInShoppingCartPath);
    }
    @Step("Finding shopping cart status information")
    private SelenideElement findShoppingCartStatusInfo() {
        return ElementFinder.findExistingElement.apply(shoppingCardStatusInfoPath);
    }

}
