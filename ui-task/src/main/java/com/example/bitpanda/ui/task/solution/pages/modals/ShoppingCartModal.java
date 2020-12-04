package com.example.bitpanda.ui.task.solution.pages.modals;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.pages.CheckoutPage;
import com.example.bitpanda.ui.task.solution.pages.sections.shopping.cart.modal.ProductSection;
import com.example.bitpanda.ui.task.solution.pages.sections.shopping.cart.modal.ShoppingCartSection;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

public class ShoppingCartModal {
    private final By modalRootPath = Selectors.byXpath("//div[@id='layer_cart']");
    private final By modalTitlePath = Selectors.byXpath(".//descendant::i/parent::h2");
    private final By closeModalButtonPath = Selectors.byTitle("Close window");
    private final By continueShoppingButtonPath = Selectors.byTitle("Continue shopping");
    private final By proceedToCheckoutButtonPath = Selectors.byTitle("Proceed to checkout");

    @Getter
    private final ProductSection productSection = new ProductSection();
    @Getter
    private final ShoppingCartSection shoppingCartSection = new ShoppingCartSection();

    @Step("Checking that shopping cart modal is visible")
    public ShoppingCartModal modalShouldBeVisible() {
        findModalRoot().shouldBe(Condition.visible);
        return this;
    }

    @Step("Closing modal")
    public void closeModal() {
        ElementActions.clickOnClickableElement(findCloseModalButton());
    }

    @Step("Clicking on continue shopping button")
    public void continueShopping() {
        ElementActions.clickOnClickableElement(findContinueShoppingButton());
    }

    @Step("Clicking on proceed to checkout button")
    public CheckoutPage proceedToCheckout() {
        ElementActions.clickOnClickableElement(findProceedToCheckoutButton());
        return new CheckoutPage();
    }

    @Step("Checking modal title")
    public ShoppingCartModal checkModalTitle(String expectedTitle) {
        findModalTitle().shouldHave(Condition.ownText(expectedTitle));
        return this;
    }

    @Step("Finding proceed to checkout button")
    private SelenideElement findProceedToCheckoutButton() {
        return ElementFinder.findInteractableElement.apply(proceedToCheckoutButtonPath);
    }

    @Step("Finding continue shopping button")
    private SelenideElement findContinueShoppingButton() {
        return ElementFinder.findInteractableElement.apply(continueShoppingButtonPath);
    }

    @Step("Finding close modal button")
    private SelenideElement findCloseModalButton() {
        return ElementFinder.findInteractableElement.apply(closeModalButtonPath);
    }



    @Step("Finding modal title")
    private SelenideElement findModalTitle() {
        return ElementFinder.findNestedReadableElement
                .apply(findModalRoot(), modalTitlePath);
    }

    @Step("Finding modal")
    private SelenideElement findModalRoot() {
        return ElementFinder.findExistingElement.apply(modalRootPath);
    }
}
