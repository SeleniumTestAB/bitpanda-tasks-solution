package com.example.bitpanda.ui.task.solution.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    private final By createAccountEmailInputPath = Selectors.byId("email_create");
    private final By createAccountButtonPath = Selectors.byId("SubmitCreate");
    private final By loginPageBodyPath = Selectors.byXpath("//body[@id='authentication']");

    @Step("Verifying that Client is on Login Page")
    public LoginPage verifyClientIsOnLoginPage() {
        findLoginPageBody();
        return this;
    }

    @Step("Starting account creation process")
    public CreateAccountFormPage startAccountCreationProcess() {
        findCreateAccountButton().submit();
        return new CreateAccountFormPage();
    }

    @Step("Filling new account email field")
    public LoginPage fillInNewAccountEmail(String newEmailAddress) {
        ElementActions.fillField(findCreateEmailInput(), newEmailAddress);
        return this;
    }

    @Step("Finding Login Page body")
    private SelenideElement findLoginPageBody() {
        return ElementFinder.findExistingElement.apply(loginPageBodyPath);
    }


    @Step("Finding create account button")
    private SelenideElement findCreateAccountButton() {
        return ElementFinder.findInteractableElement.apply(createAccountButtonPath);
    }

    @Step("Finding creat email input")
    private SelenideElement findCreateEmailInput() {
        return ElementFinder.findInteractableElement.apply(createAccountEmailInputPath);
    }
}
