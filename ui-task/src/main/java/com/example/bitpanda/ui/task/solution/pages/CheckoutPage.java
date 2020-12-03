package com.example.bitpanda.ui.task.solution.pages;

import com.codeborne.selenide.Selectors;
import com.example.bitpanda.ui.task.solution.pages.sections.checkout.page.AddressSummarySection;
import com.example.bitpanda.ui.task.solution.pages.sections.checkout.page.PaymentSection;
import com.example.bitpanda.ui.task.solution.pages.sections.checkout.page.ShippingSection;
import com.example.bitpanda.ui.task.solution.pages.sections.checkout.page.SummarySection;
import com.example.bitpanda.ui.task.solution.utils.ElementFinder;
import lombok.Getter;
import org.openqa.selenium.By;

public class CheckoutPage {
    private final By checkoutPageBodyPath = Selectors.byXpath("//body[@id='order']");
    @Getter
    private final SummarySection summarySection = new SummarySection();
    @Getter
    private final AddressSummarySection addressSummarySection = new AddressSummarySection();
    @Getter
    private final ShippingSection shippingSection = new ShippingSection();
    @Getter
    private final PaymentSection paymentSection = new PaymentSection();


    public CheckoutPage verifyIfClientIsOnCheckoutPage() {
        ElementFinder.findExistingElement.apply(checkoutPageBodyPath);
        return this;
    }
}
