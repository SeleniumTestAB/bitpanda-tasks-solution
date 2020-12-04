package com.example.bitpanda.ui.task.solution.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.value;

@UtilityClass
public class ElementActions extends Expectations {

    @Step("Filling field")
    public void fillField(SelenideElement field, String givenValue) {
        field.append(givenValue)
                .shouldNotBe(empty)
                .shouldHave(value(givenValue));
    }

    public void clearField(SelenideElement field) {
        field.clear();
    }

    @Step("Forcing element to be visible via JS")
    public void forceElementToBeVisible(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].visible='true'", element);
    }


    @Step("Clicking on a clickable element")
    public void clickOnClickableElement(SelenideElement element) {
        element.shouldBe(active).click();
    }


}
