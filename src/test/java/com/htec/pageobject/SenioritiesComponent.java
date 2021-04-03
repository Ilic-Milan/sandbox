package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SenioritiesComponent extends BasePage {

    @FindBy(xpath = "//b[contains(text(), 'Seniorities')]")
    private WebElement senioritiesTitle;
    @FindBy(css = "a[href='/create-seniority']")
    private WebElement createSeniority;
    @FindBy(css = ".list-group-item.list-group-item-action")
    private List<WebElement> seniorities;

    private PlaygroundPage playgroundPage;
    private NewSeniorityPage newSeniorityPage;

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

    public boolean isPresentAnySeniority() {
        return seniorities.size() != 0;
    }

    public boolean isPresentSeniority(String seniority) {
        for (int i = 0; i < seniorities.size(); i++) {
            if(seniorities.get(i).getText().equals(seniority))
                return true;
        }
        return false;
    }
}
