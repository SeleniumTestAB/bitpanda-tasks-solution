package com.example.bitpanda.ui.task.solution.pages.sections.items;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.pages.modals.ShoppingCardModal;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import org.openqa.selenium.By;

public class HomeFeaturedItem {
    private final By homeFeaturedRoot;
    private final String itemName;
    private final By addToCardButtonPath = Selectors.byXpath("./ancestor::div/descendant::a[@title='Add to cart']");

    public HomeFeaturedItem(By homeFeaturedRoot, String itemName) {
        this.homeFeaturedRoot = homeFeaturedRoot;
        this.itemName = itemName;
    }



    public HomeFeaturedItem hoverOnImage() {
        findItemImage().hover();
        return this;
    }

    public ShoppingCardModal addItemToCard() {
        ElementActions.clickOnClickableElement(findAddToCardButton());
        return new ShoppingCardModal();
    }

    private SelenideElement findAddToCardButton() {
        return ElementFinder.findNestedInteractableElement
                .apply(findSectionRoot(), addToCardButtonPath);
    }

    private SelenideElement findItemImage() {
        return ElementFinder.findNestedReadableElement
                .apply(findSectionRoot(), buildPathToItemsImage());
    }

    private SelenideElement findItemName() {
        return ElementFinder.findNestedExistingElement
                .apply(findSectionRoot(), buildPathToItemsName());
    }

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
