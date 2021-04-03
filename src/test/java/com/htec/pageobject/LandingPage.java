package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    @FindBy(css = ".btn-secondary")
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
        waitForIsDisplayedAndGetElement(this.loginBtn).click();
    }

}
