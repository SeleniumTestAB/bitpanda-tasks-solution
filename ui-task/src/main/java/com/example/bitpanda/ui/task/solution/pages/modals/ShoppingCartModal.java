package com.example.bitpanda.ui.task.solution.pages.modals;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.pages.sections.shopping.cart.modal.ProductSection;
import com.example.bitpanda.ui.task.solution.pages.sections.shopping.cart.modal.ShoppingCartSection;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import lombok.Getter;
import org.openqa.selenium.By;

public class ShoppingCartModal {
    private final By modalRootPath = Selectors.byXpath("//div[@id='layer_cart']");
    private final By modalTitlePath = Selectors.byXpath(".//descendant::i/parent::h2");


    private final By modalFieldLabelPath = Selectors.byXpath("./preceding-sibling::strong[@class='dark']");
    private final By closeModalButtonPath = Selectors.byTitle("Close window");
    private final By continueShoppingButtonPath = Selectors.byTitle("Continue shopping");
    private final By proceedToCheckoutButtonPath = Selectors.byTitle("Proceed to checkout");

    @Getter
    private final ProductSection productSection = new ProductSection();
    @Getter
    private final ShoppingCartSection shoppingCartSection = new ShoppingCartSection();

    public ShoppingCartModal modalShouldBeVisible() {
        findModalRoot().shouldBe(Condition.visible);
        return this;
    }

    public void closeModal() {
        ElementActions.clickOnClickableElement(findCloseModalButton());
    }
    public void continueShopping() {
        ElementActions.clickOnClickableElement(findContinueShoppingButton());
    }

    public void proceedToCheckout() {
        ElementActions.clickOnClickableElement(findProceedToCheckoutButton());
    }

    public ShoppingCartModal checkModalTitle(String expectedTitle) {
        findModalTitle().shouldHave(Condition.ownText(expectedTitle));
        return this;
    }

    private SelenideElement findProceedToCheckoutButton() {
        return ElementFinder.findInteractableElement.apply(proceedToCheckoutButtonPath);
    }

    private SelenideElement findContinueShoppingButton() {
        return ElementFinder.findInteractableElement.apply(continueShoppingButtonPath);
    }

    private SelenideElement findCloseModalButton() {
        return ElementFinder.findInteractableElement.apply(closeModalButtonPath);
    }


    private SelenideElement findFieldLabel(SelenideElement givenField) {
        return ElementFinder.findNestedExistingElement.apply(givenField, modalFieldLabelPath);
    }


    private SelenideElement findModalTitle() {
        return ElementFinder.findNestedReadableElement
                .apply(findModalRoot(), modalTitlePath);
    }

    private SelenideElement findModalRoot() {
        return ElementFinder.findExistingElement.apply(modalRootPath);
    }
}
