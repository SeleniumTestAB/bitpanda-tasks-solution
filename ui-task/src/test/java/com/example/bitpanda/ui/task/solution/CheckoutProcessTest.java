package com.example.bitpanda.ui.task.solution;

import com.example.bitpanda.ui.task.solution.data.ClientAccount;
import com.example.bitpanda.ui.task.solution.pages.CheckoutPage;
import com.example.bitpanda.ui.task.solution.pages.LoginPage;
import com.example.bitpanda.ui.task.solution.pages.modals.ShoppingCartModal;
import org.testng.annotations.Test;

public class CheckoutProcessTest extends BaseTest {
    private final ClientAccount clientAccount = new ClientAccount("Mr.");
    private ShoppingCartModal shoppingCartModal;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;
    private final String TEST_PRODUCT_NAME = "Faded Short Sleeve T-shirts";



    @Test(priority = 1, groups = {"checkout"})
    public void clientShouldBeAbleToAddProductToCard() {
        shoppingCartModal = homePage.getHomeFeaturedSection()
                .scrollToSection()
                .getItem(TEST_PRODUCT_NAME)
                .hoverOnImage()
                .addItemToCard()
                .modalShouldBeVisible();

    }


    @Test(priority = 2, groups = {"checkout"})
    public void clientShouldBeAbleToProceedToCheckout() {
        checkoutPage = shoppingCartModal.proceedToCheckout()
                .verifyIfClientIsOnCheckoutPage();
    }

    @Test(priority = 3, groups = {"checkout"})
    public void checkoutSummaryShouldHaveProperProductInfo() {
        checkoutPage.getSummarySection().checkIfProductImageIsVisible(TEST_PRODUCT_NAME)
                .checkAvailabilityOfAProduct(TEST_PRODUCT_NAME, "In stock");
    }

    @Test(priority = 4, groups = {"checkout"})
    public void unsignedClientShouldProceedToLoginPage() {
        loginPage = checkoutPage.getSummarySection().proceedFurtherToCheckout()
                .verifyClientIsOnLoginPage();
    }

    @Test(priority = 5, groups = {"checkout"})
    public void clientShouldBeAbleToCreateAccount() {
        loginPage.fillInNewAccountEmail(clientAccount.email())
                .startAccountCreationProcess()
                .fillPersonalInformation(clientAccount)
                .fillAddress(clientAccount)
                .registerNewAccountDuringCheckout();
    }

    @Test(priority = 6, groups = {"checkout"})
    public void clientShouldBeAbleToVerifyDeliveryAndBillingAddress() {
        checkoutPage.getAddressSummarySection()
                .verifyDeliveryAddress(clientAccount, "United States")
                .verifyBillingAddress(clientAccount, "United States");
    }

    @Test(priority = 7, groups = {"checkout"})
    public void clientShouldBeAbleToConsentForTermsOfService() {
        checkoutPage.getAddressSummarySection().proceedFurther()
                .agreeToTermsOfService();
    }

    @Test(priority = 8, groups = {"checkout"})
    public void clientShouldBeAbleToChoosePaymentByBankWire() {
        checkoutPage.getShippingSection().processToPayment()
                .choosePayByWireOption();
    }

    @Test(priority = 9, groups = {"checkout"})
    public void clientShouldBeAbleToCompleteOrder() {
        checkoutPage.getPaymentSection()
                .confirmOrder();
    }

}