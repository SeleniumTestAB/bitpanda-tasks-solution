package com.example.bitpanda.ui.task.solution.pages.sections.create.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonalInformationSection {
    private final By maleGenderRadioPath = Selectors.byXpath("//input[@id='id_gender1']");
    private final By femaleGenderRadioPath = Selectors.byXpath("//input[@id='id_gender2']");
    private final By firstNameInputPath = Selectors.byId("customer_firstname");
    private final By lastNameInputPath = Selectors.byId("customer_lastname");
    private final By emailInputPath = Selectors.byId("email");
    private final By passwordInputPath = Selectors.byId("passwd");

    public PersonalInformationSection checkPasswordValidation(boolean positive) {
        checkValidationOfInput(findPasswordInput(), positive);
        return this;
    }

    public PersonalInformationSection checkEmailValidation(boolean positive) {
        checkValidationOfInput(findEmailInput(), positive);
        return this;
    }

    public PersonalInformationSection checkLastNameValidation(boolean positive) {
        checkValidationOfInput(findLastNameInput(), positive);
        return this;
    }

    public PersonalInformationSection checkFirstNameValidation(boolean positive) {
        checkValidationOfInput(findFirstNameInput(), positive);
        return this;
    }

    public PersonalInformationSection fillPassword(String givenPassword) {
        ElementActions.fillField(findPasswordInput(), givenPassword);
        return this;
    }

    public PersonalInformationSection checkIfEmailIsPreFilled(String givenEmail) {
        findEmailInput().click();
        findEmailInput().pressTab().shouldHave(Condition.value(givenEmail));
        return this;
    }

    public PersonalInformationSection fillLastName(String givenLastName) {
        ElementActions.fillField(findLastNameInput(), givenLastName);
        return this;
    }

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

    public PersonalInformationSection fillFirstName(String givenFirstName) {
        ElementActions.fillField(findFirstNameInput(), givenFirstName);
        return this;
    }

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

    private void positiveValidationOfInput(SelenideElement givenInput) {
        String validationAttribute = getInputValidationAttribute(givenInput);
        assertThat(validationAttribute).contains("form-ok");
    }

    private void negativeValidationOfInput(SelenideElement givenInput) {
        String validationAttribute = getInputValidationAttribute(givenInput);
        assertThat(validationAttribute).contains("form-error");
    }

    private String getInputValidationAttribute(SelenideElement givenInput) {
        return ElementFinder.findNestedExistingElement
                .apply(givenInput, Selectors.byXpath("./parent::div"))
                .getAttribute("class");
    }

    private SelenideElement findPasswordInput() {
        return ElementFinder.findInteractableElement.apply(passwordInputPath);
    }

    private SelenideElement findEmailInput() {
        return ElementFinder.findInteractableElement.apply(emailInputPath);
    }

    private SelenideElement findLastNameInput() {
        return ElementFinder.findInteractableElement.apply(lastNameInputPath);
    }

    private SelenideElement findFirstNameInput() {
        return ElementFinder.findInteractableElement.apply(firstNameInputPath);
    }

    private SelenideElement findMaleGenderRadio() {
        return ElementFinder.findActiveElement.apply(maleGenderRadioPath);
    }


    private SelenideElement findFemaleGenderRadio() {
        return ElementFinder.findActiveElement.apply(femaleGenderRadioPath);
    }
}
