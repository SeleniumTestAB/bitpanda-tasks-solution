package com.example.bitpanda.ui.task.solution.pages.sections.checkout.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import org.openqa.selenium.By;

public class ShippingSection {
    private final By consentCheckboxPath = Selectors.byXpath("//input[@id='cgv']/parent::span");
    private final By processCarrierButtonPath = Selectors.byName("processCarrier");

    public ShippingSection agreeToTermsOfService() {
        ElementActions.clickOnClickableElement(findConsentCheckbox());
        findConsentCheckbox().shouldHave(Condition.attribute("class", "checked"));
        return this;
    }

    public PaymentSection processToPayment() {
        ElementActions.clickOnClickableElement(findProcessCarrierButton());
        return new PaymentSection();
    }

    private SelenideElement findProcessCarrierButton() {
        return ElementFinder.findInteractableElement.apply(processCarrierButtonPath);
    }

    private SelenideElement findConsentCheckbox() {
        return ElementFinder.findActiveElement.apply(consentCheckboxPath);
    }
}
