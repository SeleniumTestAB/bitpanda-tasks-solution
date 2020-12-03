package com.example.bitpanda.ui.task.solution.pages.sections.create.account;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import org.openqa.selenium.By;

public class AddressSection {
    private final By firstNameInputPath = Selectors.byId("firstname");
    private final By lastNameInputPath = Selectors.byId("lastname");
    private final By addressInputPath = Selectors.byId("address1");
    private final By cityInputPath = Selectors.byId("city");
    private final By stateListPath = Selectors.byId("id_state");
    private final By postCodeInputPath = Selectors.byId("postcode");
    private final By mobilePhoneInputPath = Selectors.byId("phone_mobile");

    public AddressSection fillFirstName(String givenFirstName) {
        ElementActions.fillField(findFirstNameInput(), givenFirstName);
        return this;
    }

    public AddressSection fillLastName(String givenLastName) {
        ElementActions.fillField(findLastNameInput(), givenLastName);
        return this;
    }

    public AddressSection fillAddress(String givenAddress) {
        ElementActions.fillField(findAddressInput(), givenAddress);
        return this;
    }

    public AddressSection fillCity(String givenCity) {
        ElementActions.fillField(findCityInput(), givenCity);
        return this;
    }

    public AddressSection selectState(String givenState) {
        findStateList().selectOption(givenState);
        return this;
    }

    public AddressSection fillPostCode(String givenPostCode) {
        ElementActions.fillField(findPostCodeInput(), givenPostCode);
        return this;
    }

    public AddressSection fillMobilePhone(String givenMobilePhone) {
        ElementActions.fillField(findMobilePhoneInput(), givenMobilePhone);
        return this;
    }

    private SelenideElement findFirstNameInput() {
        return ElementFinder.findInteractableElement.apply(firstNameInputPath);
    }

    private SelenideElement findLastNameInput() {
        return ElementFinder.findInteractableElement.apply(lastNameInputPath);
    }

    private SelenideElement findAddressInput() {
        return ElementFinder.findInteractableElement.apply(addressInputPath);
    }

    private SelenideElement findCityInput() {
        return ElementFinder.findInteractableElement.apply(cityInputPath);
    }

    private SelenideElement findStateList() {
        return ElementFinder.findActiveElement.apply(stateListPath);
    }

    private SelenideElement findPostCodeInput() {
        return ElementFinder.findInteractableElement.apply(postCodeInputPath);
    }

    private SelenideElement findMobilePhoneInput() {
        return ElementFinder.findInteractableElement.apply(mobilePhoneInputPath);
    }


}
