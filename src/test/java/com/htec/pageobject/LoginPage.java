package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(css = "button[type = 'submit']")
    private WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(this.emailInput);
    }

    public void login(String username, String password) {
        populateField(waitForIsDisplayedAndGetElement(emailInput), username);
        populateField(waitForIsDisplayedAndGetElement(passwordInput), password);
        waitForIsDisplayedAndGetElement(submitBtn).click();
    }

}
