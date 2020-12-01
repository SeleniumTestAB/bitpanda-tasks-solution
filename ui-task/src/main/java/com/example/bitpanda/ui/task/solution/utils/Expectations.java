package com.example.bitpanda.ui.task.solution.utils;


import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

class Expectations {

    public static final Condition readable = and("Element is readable/visible on page", exist, visible);
    public static final Condition active = and("Element is active on page", exist, enabled);
    public static final Condition interactable = and("Element is interactable on page", active, readable);


}
