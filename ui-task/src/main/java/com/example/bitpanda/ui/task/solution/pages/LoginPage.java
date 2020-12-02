package com.example.bitpanda.ui.task.solution.pages;

import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;

public class LoginPage {
    private final By createAccountEmailInputPath = Selectors.byId("email_create");
    private final By createAccountButtonPath = Selectors.byId("SubmitCreate");
}
