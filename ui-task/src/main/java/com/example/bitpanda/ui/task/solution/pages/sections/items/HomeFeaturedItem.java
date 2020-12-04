package com.example.bitpanda.ui.task.solution.pages.sections.items;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.pages.modals.ShoppingCartModal;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomeFeaturedItem {
    private final By homeFeaturedRoot;
    private final String itemName;
    private final By addToCardButtonPath = Selectors.byXpath("./ancestor::div[@class='right-block']/descendant::a[@title='Add to cart']");

    public HomeFeaturedItem(By homeFeaturedRoot, String itemName) {
        this.homeFeaturedRoot = homeFeaturedRoot;
        this.itemName = itemName;
    }


    @Step("Hovering over product image")
    public HomeFeaturedItem hoverOnImage() {
        findItemImage().hover();
        return this;
    }

    @Step("Clicking on add to cart button")
    public ShoppingCartModal addItemToCard() {
        ElementActions.clickOnClickableElement(findAddToCardButton());
        return new ShoppingCartModal();
    }
    @Step("Finding add to cart button")
    private SelenideElement findAddToCardButton() {
        return ElementFinder.findNestedInteractableElement
                .apply(findItemName(), addToCardButtonPath);
    }
    @Step("Finding product image")
    private SelenideElement findItemImage() {
        return ElementFinder.findNestedReadableElement
                .apply(findSectionRoot(), buildPathToItemsImage());
    }
    @Step("Finding product name")
    private SelenideElement findItemName() {
        return ElementFinder.findNestedExistingElement
                .apply(findSectionRoot(), buildPathToItemsName());
    }
    @Step("Finding section where product is")
    private SelenideElement findSectionRoot() {
        return ElementFinder.findExistingElement.apply(homeFeaturedRoot);
    }

    private By buildPathToItemsImage() {
        return Selectors.byXpath("./descendant::div[@class='product-image-container']" +
                "/descendant::img[@title='" + this.itemName + "' and @itemprop='image']");
    }

    private By buildPathToItemsName() {
        return Selectors.byXpath("./descendant::h5[@itemprop='name']/a[@title='" + this.itemName + "']");
    }

}
