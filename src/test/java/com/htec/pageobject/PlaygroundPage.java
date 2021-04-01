package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaygroundPage extends BasePage{

    private PeopleComponent peopleComponent;
    private SenioritiesComponent senioritiesComponent;

    @FindBy(css = ".page-title")
    private WebElement playgroundTitle;
    @FindBy(css = "a[href='/people']")
    private WebElement people;
    @FindBy(css = "a[href='/seniorities']")
    private WebElement seniorities;

    public PlaygroundPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PeopleComponent getPeopleComponent() {
        waitForIsDisplayedAndGetElement(people).click();
        return new PeopleComponent(driver);
    }

    public SenioritiesComponent getSenioritiesComponent() {
        waitForIsDisplayedAndGetElement(seniorities).click();
        return new SenioritiesComponent(driver);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(playgroundTitle);
    }


}
