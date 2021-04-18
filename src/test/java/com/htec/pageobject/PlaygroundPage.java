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
    @FindBy(xpath = "//div[contains(@class, 'card-tabs')]//div[contains(text(), 'PEOPLE')]")
    private WebElement people;
    @FindBy(xpath = "//div[contains(@class, 'card-tabs')]//div[contains(text(), 'SENIORITIES')]")
    private WebElement seniorities;
    @FindBy(xpath = "//div[contains(@class, 'card-tabs')]//div[contains(text(), 'TECHNOLOGIES')]")
    private WebElement tehnologies;

    public PlaygroundPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PeopleComponent getPeopleComponent() {
        click(people);
        return new PeopleComponent(driver);
    }

    public SenioritiesComponent getSenioritiesComponent() {
        click(seniorities);
        return new SenioritiesComponent(driver);
    }

    public TehnologiesComponent getTehnologiesComponent() {
        click(tehnologies);
        return new TehnologiesComponent(driver);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(playgroundTitle);
    }


}
