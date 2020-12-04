package com.example.bitpanda.ui.task.solution.pages.sections.create.account;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AddressSection {
    private final By firstNameInputPath = Selectors.byId("firstname");
    private final By lastNameInputPath = Selectors.byId("lastname");
    private final By addressInputPath = Selectors.byId("address1");
    private final By cityInputPath = Selectors.byId("city");
    private final By stateListPath = Selectors.byId("id_state");
    private final By postCodeInputPath = Selectors.byId("postcode");
    private final By mobilePhoneInputPath = Selectors.byId("phone_mobile");

    @Step("Filling first name")
    public AddressSection fillFirstName(String givenFirstName) {
        ElementActions.fillField(findFirstNameInput(), givenFirstName);
        return this;
    }

    @Step("Filling last name")
    public AddressSection fillLastName(String givenLastName) {
        ElementActions.fillField(findLastNameInput(), givenLastName);
        return this;
    }

    @Step("filling Address")
    public AddressSection fillAddress(String givenAddress) {
        ElementActions.fillField(findAddressInput(), givenAddress);
        return this;
    }

    @Step("Filling city")
    public AddressSection fillCity(String givenCity) {
        ElementActions.fillField(findCityInput(), givenCity);
        return this;
    }

    @Step("Selecting state")
    public AddressSection selectState(String givenState) {
        findStateList().selectOption(givenState);
        return this;
    }

    @Step("Filling postal code")
    public AddressSection fillPostCode(String givenPostCode) {
        ElementActions.fillField(findPostCodeInput(), givenPostCode);
        return this;
    }

    @Step("Filling mobile phone")
    public AddressSection fillMobilePhone(String givenMobilePhone) {
        ElementActions.fillField(findMobilePhoneInput(), givenMobilePhone);
        return this;
    }

    @Step("Finding first name")
    private SelenideElement findFirstNameInput() {
        return ElementFinder.findInteractableElement.apply(firstNameInputPath);
    }

    @Step("Finding last name")
    private SelenideElement findLastNameInput() {
        return ElementFinder.findInteractableElement.apply(lastNameInputPath);
    }

    @Step("Finding address")
    private SelenideElement findAddressInput() {
        return ElementFinder.findInteractableElement.apply(addressInputPath);
    }

    @Step("Finding city")
    private SelenideElement findCityInput() {
        return ElementFinder.findInteractableElement.apply(cityInputPath);
    }

    @Step("Finding state list")
    private SelenideElement findStateList() {
        return ElementFinder.findActiveElement.apply(stateListPath);
    }

    @Step("Finding postal code")
    private SelenideElement findPostCodeInput() {
        return ElementFinder.findInteractableElement.apply(postCodeInputPath);
    }

    @Step("Finding mobile phone")
    private SelenideElement findMobilePhoneInput() {
        return ElementFinder.findInteractableElement.apply(mobilePhoneInputPath);
    }


}
