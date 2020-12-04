package com.example.bitpanda.ui.task.solution.pages.sections.checkout.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.example.bitpanda.ui.task.solution.utils.ElementActions;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PaymentSection {
    private final By payByBankWireOptionPath = Selectors.byTitle("Pay by bank wire");
    private final By confirmOrderButtonPath = Selectors.byXpath("//p[@id='cart_navigation']/child::button[@type='submit']");
    private final By orderCompletionNoteHeaderPath = Selectors.byXpath("//p[@class='cheque-indent']/strong[@class='dark']");

    @Step("Choosing payment by bank wire option")
    public PaymentSection choosePayByWireOption() {
        ElementActions.clickOnClickableElement(findPayByBankWireOption());
        return this;
    }

    @Step("Confirming order")
    public void confirmOrder() {
        ElementActions.clickOnClickableElement(findConfirmOrderButton());
        findOrderCompletionNoteHeader().shouldHave(Condition.ownText("Your order on My Store is complete."));

    }

    @Step("Finding order completion header note")
    private SelenideElement findOrderCompletionNoteHeader() {
        return ElementFinder.findReadableElement.apply(orderCompletionNoteHeaderPath);
    }

    @Step("Finding confirm order button")
    private SelenideElement findConfirmOrderButton() {
        return ElementFinder.findInteractableElement.apply(confirmOrderButtonPath);
    }

    @Step("Finding pay by bank wire option")
    private SelenideElement findPayByBankWireOption() {
        return ElementFinder.findInteractableElement.apply(payByBankWireOptionPath);
    }
}
