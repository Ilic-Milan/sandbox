package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PeopleComponent extends BasePage {

    @FindBy(xpath = "//b[contains(text(), 'People')]")
    private WebElement peopleTitle;
    @FindBy(css = "a[href='/create-person']")
    private WebElement createPerson;
    @FindBy(css = ".list-group-item.list-group-item-action")
    private List<WebElement> people;

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

    public boolean isPresentPeople() {
        return people.size() != 0;
    }
}
