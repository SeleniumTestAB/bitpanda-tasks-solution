package com.example.bitpanda.ui.task.solution.pages.sections.checkout.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.data.ClientAccount;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AddressBox {
    private final String boxId;
    private final By fullNamePath = Selectors.byXpath("./descendant::li[@class='address_firstname address_lastname']");
    private final By companyPath = Selectors.byXpath("./descendant::li[@class='address_company']");
    private final By fullAddressPath = Selectors.byXpath("./descendant::li[@class='address_address1 address_address2']");
    private final By mailInformationPath = Selectors.byXpath("./descendant::li[@class='address_city address_state_name address_postcode']");
    private final By countryPath = Selectors.byXpath("./descendant::li[@class='address_country_name']");
    private final By phoneMobilePath = Selectors.byXpath("./descendant::li[@class='address_phone_mobile']");


    public AddressBox(String boxId) {
        this.boxId = boxId;
    }

    @Step("Verifying full name")
    public AddressBox verifyFullName(ClientAccount clientAccount) {
        findFullName().shouldHave(Condition.ownText(clientAccount.firstName() + " " + clientAccount.lastName()));
        return this;
    }

    @Step("Verifying full address")
    public AddressBox verifyFullAddress(ClientAccount clientAccount) {
        findFullAddress().shouldHave(Condition.ownText(clientAccount.address()));
        return this;
    }

    @Step("Verifying mail information")
    public AddressBox verifyMailInformation(ClientAccount clientAccount) {
        findMailInformation().shouldHave(Condition.ownText(clientAccount.city() + ", " + clientAccount.state() + " " + clientAccount.postCode()));
        return this;
    }

    @Step("Verifying country")
    public AddressBox verifyCountry(String givenCountry) {
        findCountry().shouldHave(Condition.ownText(givenCountry));
        return this;
    }

    @Step("Verifying mobile phone")
    public AddressBox verifyMobilePhone(ClientAccount clientAccount) {
        findPhoneMobile().shouldHave(Condition.ownText(clientAccount.mobilePhone()));
        return this;
    }


    @Step("Finding full name")
    private SelenideElement findFullName() {
        return ElementFinder.findNestedReadableElement
                .apply(findAddressBox(), fullNamePath);
    }

    @Step("Finding company")
    private SelenideElement findCompany() {
        return ElementFinder.findNestedReadableElement
                .apply(findAddressBox(), companyPath);
    }

    @Step("Finding full address")
    private SelenideElement findFullAddress() {
        return ElementFinder.findNestedReadableElement
                .apply(findAddressBox(), fullAddressPath);
    }

    @Step("Finding mail information")
    private SelenideElement findMailInformation() {
        return ElementFinder.findNestedReadableElement
                .apply(findAddressBox(), mailInformationPath);
    }

    @Step("Finding country")
    private SelenideElement findCountry() {
        return ElementFinder.findNestedReadableElement
                .apply(findAddressBox(), countryPath);
    }

    @Step("Finding mobile phone")
    private SelenideElement findPhoneMobile() {
        return ElementFinder.findNestedReadableElement
                .apply(findAddressBox(), phoneMobilePath);
    }

    @Step("Finding address box")
    private SelenideElement findAddressBox() {
        return ElementFinder.findExistingElement.apply(buildPathToAddressBox());
    }

    private By buildPathToAddressBox() {
        return Selectors.byXpath("//ul[@id='" + boxId + "']");
    }
}
