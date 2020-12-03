package com.example.bitpanda.ui.task.solution.pages.sections.shopping.cart.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import org.openqa.selenium.By;

public class ShoppingCartSection extends BaseSection {
    private final By totalProductsPriceInCardPath = Selectors.byXpath("//span[@class='ajax_block_products_total']");
    private final By totalShippingCostPath = Selectors.byXpath("//span[@class='ajax_cart_shipping_cost']");
    private final By totalShoppingCostPath = Selectors.byXpath("//span[@class='ajax_block_cart_total']");
    private final By shoppingCardStatusInfoPath = Selectors.byXpath("//span[@class='ajax_cart_product_txt' or contains(@class, 'ajax_cart_product_txt')]");
    private final By quantityOfProductsInShoppingCartPath = Selectors.byXpath("//span[@class='ajax_cart_quantity']");



    public ShoppingCartSection checkShoppingCartStatusInfoIsVisible(){
        findShoppingCartStatusInfo().shouldBe(Condition.visible);
        return this;
    }

    public ShoppingCartSection checkTotalShoppingCostIsVisible(){
        findTotalShoppingCost().shouldBe(Condition.visible);
        findFieldLabel(findTotalShoppingCost()).shouldBe(Condition.visible);
        return this;
    }

    public ShoppingCartSection checkTotalShippingCostIsVisible(){
        findTotalShippingCost().shouldBe(Condition.visible);
        findFieldLabel(findTotalShippingCost()).shouldBe(Condition.visible);
        return this;
    }

    public ShoppingCartSection checkTotalProductsPriceInCardIsVisible(){
        findTotalProductsPriceInCard().shouldBe(Condition.visible);
        findFieldLabel(findTotalProductsPriceInCard()).shouldBe(Condition.visible);
        return this;
    }


    public ShoppingCartSection checkShoppingCartStatusInfo(String expectedInfo, String expectedQuantity){
        findShoppingCartStatusInfo().shouldHave(Condition.ownText(expectedInfo));
        findQuantityOfProductsInShoppingCart().shouldHave(Condition.ownText(expectedQuantity));
        return this;
    }

    public ShoppingCartSection checkShoppingCartStatusInfo(String expectedInfo){
        findShoppingCartStatusInfo().shouldHave(Condition.ownText(expectedInfo));
        return this;
    }

    public ShoppingCartSection checkTotalShoppingCostLabel(String expectedLabel) {
        findFieldLabel(findTotalShoppingCost()).shouldHave(Condition.ownText(expectedLabel));
        return this;
    }


    public ShoppingCartSection checkTotalShippingCostLabel(String expectedLabel) {
        findFieldLabel(findTotalShippingCost()).shouldHave(Condition.ownText(expectedLabel));
        return this;
    }


    public ShoppingCartSection checkTotalProductsPriceInCardLabel(String expectedLabel) {
        findFieldLabel(findTotalProductsPriceInCard()).shouldHave(Condition.ownText(expectedLabel));
        return this;
    }


    public ShoppingCartSection checkTotalShoppingCost(String expectedCost) {
        findTotalShoppingCost().shouldHave(Condition.ownText(expectedCost));
        return this;
    }

    public ShoppingCartSection checkTotalShippingCost(String expectedCost) {
        findTotalShippingCost().shouldHave(Condition.ownText(expectedCost));
        return this;
    }

    public ShoppingCartSection checkTotalProductsCost(String expectedCost) {
        findTotalProductsPriceInCard().shouldHave(Condition.ownText(expectedCost));
        return this;
    }

    private SelenideElement findTotalShoppingCost() {
        return ElementFinder.findExistingElement.apply(totalShoppingCostPath);
    }

    private SelenideElement findTotalShippingCost() {
        return ElementFinder.findExistingElement.apply(totalShippingCostPath);
    }

    private SelenideElement findTotalProductsPriceInCard() {
        return ElementFinder.findExistingElement.apply(totalProductsPriceInCardPath);
    }

    private SelenideElement findQuantityOfProductsInShoppingCart() {
        return ElementFinder.findExistingElement.apply(quantityOfProductsInShoppingCartPath);
    }

    private SelenideElement findShoppingCartStatusInfo() {
        return ElementFinder.findExistingElement.apply(shoppingCardStatusInfoPath);
    }

}
