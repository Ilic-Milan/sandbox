package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SenioritiesComponent extends BasePage {

    @FindBy(xpath = "//b[contains(text(), 'Seniorities')]")
    private WebElement senioritiesTitle;
    @FindBy(xpath = "a[href='/create-seniority']")
    private WebElement createSeniority;


    public SenioritiesComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(senioritiesTitle);
    }

    public NewSeniorityPage goToNewSeniorityForm() {
        waitForIsDisplayedAndGetElement(createSeniority).click();
        return new NewSeniorityPage(driver);
    }
}
