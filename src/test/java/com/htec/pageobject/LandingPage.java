package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login' and (contains(@class, 'btn-lg'))]")
    private WebElement loginBtn;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(this.loginBtn);
    }

    public void goTo() {
        LOGGER.info("User is opening landing page - " + config.getSandboxUrl());
        driver.get(config.getSandboxUrl());
    }

    public void openLoginForm() {
        WebElement login = waitForIsDisplayedAndGetElement(this.loginBtn);
        login.click();
    }

}
