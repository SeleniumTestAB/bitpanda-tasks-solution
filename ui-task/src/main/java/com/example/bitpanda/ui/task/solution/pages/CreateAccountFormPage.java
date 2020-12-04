package com.example.bitpanda.ui.task.solution.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.data.ClientAccount;
import com.example.bitpanda.ui.task.solution.pages.sections.checkout.page.AddressSummarySection;
import com.example.bitpanda.ui.task.solution.pages.sections.create.account.AddressSection;
import com.example.bitpanda.ui.task.solution.pages.sections.create.account.PersonalInformationSection;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CreateAccountFormPage {
    private final PersonalInformationSection personalInformationSection = new PersonalInformationSection();
    private final AddressSection addressSection = new AddressSection();
    private final By registerAccountButtonPath = Selectors.byId("submitAccount");

    @Step("Filling personal information")
    public CreateAccountFormPage fillPersonalInformation(ClientAccount clientAccount) {
        personalInformationSection.chooseGender(clientAccount.gender())
                .fillFirstName(clientAccount.firstName())
                .fillLastName(clientAccount.lastName())
                .fillPassword(clientAccount.password())
                .checkIfEmailIsPreFilled(clientAccount.email())
                .checkEmailValidation(true)
                .checkFirstNameValidation(true)
                .checkLastNameValidation(true)
                .checkPasswordValidation(true);
        return this;
    }

    @Step("Filling address information")
    public CreateAccountFormPage fillAddress(ClientAccount clientAccount) {
        addressSection.fillFirstName(clientAccount.firstName())
                .fillLastName(clientAccount.lastName())
                .fillAddress(clientAccount.address())
                .fillCity(clientAccount.city())
                .selectState(clientAccount.state())
                .fillPostCode(clientAccount.postCode())
                .fillMobilePhone(clientAccount.mobilePhone());
        return this;
    }


    @Step("Clicking on register button")
    public AddressSummarySection registerNewAccountDuringCheckout() {
        ElementActions.clickOnClickableElement(findRegisterAccountButton());
        return new AddressSummarySection();
    }

    @Step("Finding register button")
    private SelenideElement findRegisterAccountButton() {
        return ElementFinder.findInteractableElement.apply(registerAccountButtonPath);
    }

}
