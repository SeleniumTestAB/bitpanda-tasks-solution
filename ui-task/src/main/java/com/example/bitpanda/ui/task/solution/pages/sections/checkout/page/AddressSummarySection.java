package com.example.bitpanda.ui.task.solution.pages.sections.checkout.page;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.data.ClientAccount;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AddressSummarySection {
    private final AddressBox deliveryAddressBox = new AddressBox("address_delivery");
    private final AddressBox billingAddressBox = new AddressBox("address_invoice");
    private final By processAddressButtonPath = Selectors.byName("processAddress");

    @Step("Verifying delivery address information")
    public AddressSummarySection verifyDeliveryAddress(ClientAccount clientAccount, String country) {
        deliveryAddressBox.verifyFullName(clientAccount)
                .verifyFullAddress(clientAccount)
                .verifyMailInformation(clientAccount)
                .verifyCountry(country)
                .verifyMobilePhone(clientAccount);
        return this;
    }

    @Step("Verifying billing address information")
    public AddressSummarySection verifyBillingAddress(ClientAccount clientAccount, String country) {
        billingAddressBox.verifyFullName(clientAccount)
                .verifyFullAddress(clientAccount)
                .verifyMailInformation(clientAccount)
                .verifyCountry(country)
                .verifyMobilePhone(clientAccount);
        return this;
    }

    @Step("Proceeding further in checkout process")
    public ShippingSection proceedFurther() {
        ElementActions.clickOnClickableElement(findProcessAddressButton());
        return new ShippingSection();
    }

    @Step("Finding process address button")
    private SelenideElement findProcessAddressButton() {
        return ElementFinder.findInteractableElement.apply(processAddressButtonPath);
    }
}
