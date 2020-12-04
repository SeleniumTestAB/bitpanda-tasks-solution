package com.example.bitpanda.ui.task.solution.pages.sections.create.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonalInformationSection {
    private final By maleGenderRadioPath = Selectors.byXpath("//input[@id='id_gender1']");
    private final By femaleGenderRadioPath = Selectors.byXpath("//input[@id='id_gender2']");
    private final By firstNameInputPath = Selectors.byId("customer_firstname");
    private final By lastNameInputPath = Selectors.byId("customer_lastname");
    private final By emailInputPath = Selectors.byId("email");
    private final By passwordInputPath = Selectors.byId("passwd");

    @Step("Checking validation status for password")
    public PersonalInformationSection checkPasswordValidation(boolean positive) {
        checkValidationOfInput(findPasswordInput(), positive);
        return this;
    }

    @Step("Checking validation status for email")
    public PersonalInformationSection checkEmailValidation(boolean positive) {
        checkValidationOfInput(findEmailInput(), positive);
        return this;
    }

    @Step("Checking validation status for last name")
    public PersonalInformationSection checkLastNameValidation(boolean positive) {
        checkValidationOfInput(findLastNameInput(), positive);
        return this;
    }

    @Step("Checking validation status for first name")
    public PersonalInformationSection checkFirstNameValidation(boolean positive) {
        checkValidationOfInput(findFirstNameInput(), positive);
        return this;
    }

    @Step("Filling password")
    public PersonalInformationSection fillPassword(String givenPassword) {
        ElementActions.fillField(findPasswordInput(), givenPassword);
        return this;
    }

    @Step("Checking if email was already pre filled")
    public PersonalInformationSection checkIfEmailIsPreFilled(String givenEmail) {
        findEmailInput().click();
        findEmailInput().pressTab().shouldHave(Condition.value(givenEmail));
        return this;
    }

    @Step("Filling last name")
    public PersonalInformationSection fillLastName(String givenLastName) {
        ElementActions.fillField(findLastNameInput(), givenLastName);
        return this;
    }

    @Step("Choosing gender")
    public PersonalInformationSection chooseGender(String givenGender) {
        switch (givenGender) {
            case "Mr.":
                findMaleGenderRadio().click();
                genderRadioShouldBeChecked(findMaleGenderRadio());
                break;
            case "Mrs.":
                findFemaleGenderRadio().click();
                genderRadioShouldBeChecked(findFemaleGenderRadio());
                break;
        }
        return this;
    }

    @Step("Filling first name")
    public PersonalInformationSection fillFirstName(String givenFirstName) {
        ElementActions.fillField(findFirstNameInput(), givenFirstName);
        return this;
    }

    @Step("Checking that correct gender was chosen")
    private void genderRadioShouldBeChecked(SelenideElement radio) {
        ElementFinder.findNestedExistingElement
                .apply(radio, Selectors.byXpath("./parent::span"))
                .shouldHave(Condition.attribute("class", "checked"));
    }

    private void checkValidationOfInput(SelenideElement givenInput, boolean positive) {
        if (positive) {
            positiveValidationOfInput(givenInput);
        } else {
            negativeValidationOfInput(givenInput);
        }
    }

    @Step("Checking for positive validation")
    private void positiveValidationOfInput(SelenideElement givenInput) {
        String validationAttribute = getInputValidationAttribute(givenInput);
        assertThat(validationAttribute).contains("form-ok");
    }

    @Step("Checking for negative validation")
    private void negativeValidationOfInput(SelenideElement givenInput) {
        String validationAttribute = getInputValidationAttribute(givenInput);
        assertThat(validationAttribute).contains("form-error");
    }

    @Step("Getting validation attribute")
    private String getInputValidationAttribute(SelenideElement givenInput) {
        return ElementFinder.findNestedExistingElement
                .apply(givenInput, Selectors.byXpath("./parent::div"))
                .getAttribute("class");
    }

    @Step("Finding password")
    private SelenideElement findPasswordInput() {
        return ElementFinder.findInteractableElement.apply(passwordInputPath);
    }

    @Step("Finding email")
    private SelenideElement findEmailInput() {
        return ElementFinder.findInteractableElement.apply(emailInputPath);
    }

    @Step("Finding last name")
    private SelenideElement findLastNameInput() {
        return ElementFinder.findInteractableElement.apply(lastNameInputPath);
    }

    @Step("Finding first name")
    private SelenideElement findFirstNameInput() {
        return ElementFinder.findInteractableElement.apply(firstNameInputPath);
    }

    @Step("Finding male gender radiobutton")
    private SelenideElement findMaleGenderRadio() {
        return ElementFinder.findActiveElement.apply(maleGenderRadioPath);
    }

    @Step("Finding female gender radiobutton")
    private SelenideElement findFemaleGenderRadio() {
        return ElementFinder.findActiveElement.apply(femaleGenderRadioPath);
    }
}
