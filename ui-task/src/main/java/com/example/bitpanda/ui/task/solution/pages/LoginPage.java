package com.example.bitpanda.ui.task.solution.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import org.openqa.selenium.By;

public class LoginPage {
    private final By createAccountEmailInputPath = Selectors.byId("email_create");
    private final By createAccountButtonPath = Selectors.byId("SubmitCreate");
    private final By loginPageBodyPath = Selectors.byXpath("//body[@id='authentication']");

    public LoginPage verifyClientIsOnLoginPage() {
        findLoginPageBody();
        return this;
    }

    public CreateAccountFormPage startAccountCreationProcess() {
        findCreateAccountButton().submit();
        return new CreateAccountFormPage();
    }

    public LoginPage fillInNewAccountEmail(String newEmailAddress) {
        ElementActions.fillField(findCreateEmailInput(), newEmailAddress);
        return this;
    }

    private SelenideElement findLoginPageBody() {
        return ElementFinder.findExistingElement.apply(loginPageBodyPath);
    }

    private SelenideElement findCreateAccountButton() {
        return ElementFinder.findInteractableElement.apply(createAccountButtonPath);
    }

    private SelenideElement findCreateEmailInput() {
        return ElementFinder.findInteractableElement.apply(createAccountEmailInputPath);
    }
}
