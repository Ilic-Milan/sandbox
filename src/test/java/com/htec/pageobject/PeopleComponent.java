package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PeopleComponent extends BasePage {

    @FindBy(xpath = "//b[contains(text(), 'People')]")
    private WebElement peopleTitle;
    @FindBy(xpath = "a[href='/create-person']")
    private WebElement createPerson;

    public PeopleComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(peopleTitle);
    }

    public NewPersonPage goToNewPersonForm() {
        waitForIsDisplayedAndGetElement(createPerson).click();
        return new NewPersonPage(driver);
    }
}
