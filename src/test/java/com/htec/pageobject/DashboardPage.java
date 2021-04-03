package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Dashboard')]")
    private WebElement dashboard;
    @FindBy(css = "a[href='/projects'] img[class='card-img-top']")
    private WebElement playground;
    @FindBy(css = "a[href='#top']")
    private WebElement logoutBtn;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(this.dashboard);
    }

    public PlaygroundPage openPlayground() {
        waitForIsDisplayedAndGetElement(this.playground).click();
        return new PlaygroundPage(driver);
    }

    public void logout() {
        waitForIsDisplayedAndGetElement(logoutBtn).click();
        waitForIsNotDisplayed(logoutBtn);
    }
}
