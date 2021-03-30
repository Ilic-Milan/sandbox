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

    public void goTo() {
        driver.get(config.getSandboxUrl());
    }

    public void openLoginForm() {
        WebElement login = wait.until(ExpectedConditions.visibilityOf(loginBtn));
        login.click();
    }

}
