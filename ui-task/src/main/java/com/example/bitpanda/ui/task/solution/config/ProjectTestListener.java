package com.example.bitpanda.ui.task.solution.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.lang3.StringUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.Map;

public class ProjectTestListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        Configuration.browser = System.getProperty("selenide.browser", "firefox");
        if(StringUtils.equals(System.getenv("isHeadless"), "true")) {
            Configuration.headless = true;
        }
        Map.of("firefox", WebDriverManager.firefoxdriver(),
                "chrome", WebDriverManager.chromedriver(),
                "edge", WebDriverManager.edgedriver(),
                "phantomjs", WebDriverManager.phantomjs())
                .get(Configuration.browser)
                .setup();

        Configuration.timeout = 15000;
        SelenideLogger.addListener("Allure", new AllureSelenide().screenshots(true)
                .savePageSource(false).includeSelenideSteps(true));
    }
}
