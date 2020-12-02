package com.example.bitpanda.ui.task.solution;

import com.codeborne.selenide.Condition;
import com.example.bitpanda.ui.task.solution.pages.modals.ShoppingCartModal;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCartModalTests extends BaseTest {
    private ShoppingCartModal shoppingCartModal;

    @BeforeGroups("modalTests")
    public void setupTests() {
        homePage.openPage();
    }

    @Test(priority = 1, groups = {"modalTests"})
    public void assureThatShoppingModalAppearsOnHomePage() {
        shoppingCartModal = homePage.getHomeFeaturedSection()
                .scrollToSection()
                .getItem("Blouse")
                .hoverOnImage()
                .addItemToCard().modalShouldBeVisible();
    }

    @Test(groups = {"modalTests"}, dependsOnMethods = {"assureThatShoppingModalAppearsOnHomePage"})
    public void modalShouldHaveMessageForSuccessfullyAddedProductToCart() {
        shoppingCartModal.checkModalTitle("Product successfully added to your shopping cart");
    }

    @Test(groups = {"modalTests"}, dependsOnMethods = {"assureThatShoppingModalAppearsOnHomePage"})
    public void modalShouldHaveVisibleProductInformation() {
        shoppingCartModal.getProductSection()
                .checkAddedProductNameIsVisible()
                .checkAddedProductAttributesAreVisible()
                .checkAddedProductQuantityIsVisible()
                .checkAddedProductPriceIsVisible();
    }

    @Test(groups = {"modalTests"}, dependsOnMethods = {"assureThatShoppingModalAppearsOnHomePage"})
    public void modalShouldHaveVisibleCurrentCartInformation() {
        shoppingCartModal.getShoppingCartSection()
                .checkShoppingCartStatusInfoIsVisible()
                .checkTotalProductsPriceInCardIsVisible()
                .checkTotalShippingCostIsVisible()
                .checkTotalShoppingCostIsVisible();
    }

    @Test(groups = {"modalTests"}, dependsOnMethods = {"assureThatShoppingModalAppearsOnHomePage"})
    public void modalShouldHaveProperLabelsForProductInformation() {
        shoppingCartModal.getProductSection()
                .checkAddedProductPriceLabel("Total")
                .checkAddedProductQuantityLabel("Quantity");
    }

    @Test(groups = {"modalTests"}, dependsOnMethods = {"assureThatShoppingModalAppearsOnHomePage"})
    public void modalShouldContainProperProductName() {
        shoppingCartModal.getProductSection()
                .checkAddedProductName("Blouse");

    }

    @Test(groups = {"modalTests"}, dependsOnMethods = {"assureThatShoppingModalAppearsOnHomePage"})
    public void modalShouldContainProperProductAttributes() {
        shoppingCartModal.getProductSection()
                .checkAddedProductAttributes("Black", "S");

    }


    @Test(groups = {"modalTests"}, dependsOnMethods = {"assureThatShoppingModalAppearsOnHomePage"})
    public void modalShouldContainProperAddedQuantityOfProduct() {
        shoppingCartModal.getProductSection()
                .checkQuantityOfAddedProducts("1");

    }

    @Test(priority = 9, groups = {"modalTests"})
    public void clientShouldBeAbleToContinueShopping() {
        shoppingCartModal.continueShopping();
        $x("//body[@id='order']").shouldNot(Condition.exist);
    }

}
