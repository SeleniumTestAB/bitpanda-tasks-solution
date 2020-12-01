package com.example.bitpanda.ui.task.solution.utils;



import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;

import java.util.function.BiFunction;
import java.util.function.Function;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
@UtilityClass
public class ElementFinder extends Expectations{
    public Function<By, SelenideElement> findExistingElement = (elementPath -> $(elementPath).should(exist));
    public Function<By, SelenideElement> findReadableElement = (elementPath -> $(elementPath).shouldBe(readable));
    public Function<By, SelenideElement> findActiveElement = (elementPath -> $(elementPath).shouldBe(active));
    public Function<By, SelenideElement> findInteractableElement = (elementPath -> $(elementPath).shouldBe(interactable));
    public BiFunction<SelenideElement, By, SelenideElement> findNestedExistingElement = (parent, childPath) -> parent.find(childPath).should(exist);
    public BiFunction<SelenideElement, By, SelenideElement> findNestedReadableElement = (parent, childPath) -> parent.find(childPath).shouldBe(readable);
    public BiFunction<SelenideElement, By, SelenideElement> findNestedActiveElement = (parent, childPath) -> parent.find(childPath).shouldBe(active);
    public BiFunction<SelenideElement, By, SelenideElement> findNestedInteractableElement = (parent, childPath) -> parent.find(childPath).shouldBe(interactable);
    public Function<By, ElementsCollection> findExistingElements = (elementsPath -> $$(elementsPath).filter(exist));
    public Function<By, ElementsCollection> findReadableElements = (elementsPath -> $$(elementsPath).filter(readable));
    public Function<By, ElementsCollection> findActiveElements = (elementsPath -> $$(elementsPath).filter(active));
    public Function<By, ElementsCollection> findInteractableElements = (elementsPath -> $$(elementsPath).filter(interactable));
    public BiFunction<SelenideElement, By, ElementsCollection> findNestedExistingElements = (parent, pathToChildren) -> parent.findAll(pathToChildren).filter(exist);




}
