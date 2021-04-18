package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class TehnologiesComponent extends BasePage {

    @FindBy(xpath = "//b[contains(text(), 'Technologies')]")
    private WebElement tehnologiesTitle;
    @FindBy(css = "a[href='/create-technology']")
    private WebElement createTehnology;
    @FindBy(css = ".list-group-item")
    private List<WebElement> tehnologies;

    public TehnologiesComponent (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(tehnologiesTitle);
    }

    public NewTehnologyPage goToNewTehnologyForm() {
        click(createTehnology);
        return new NewTehnologyPage(driver);
    }

    public boolean isPresentAnyTehnology() {
        return tehnologies.size() !=0;
    }

    public boolean isPresentTechnology(String technology) {
        for (int i = 0; i < tehnologies.size(); i++) {
            if(tehnologies.get(i).getText().equals(technology))
                return true;
        }
        return false;
    }

    public void createTechnologyIfNoAny() {
        if(!isPresentAnyTehnology()) {
            NewTehnologyPage newTehnologyPage = goToNewTehnologyForm();
            String tehnology = newTehnologyPage.createTehnology();
            assertTrue(isAt(), "User is not on Tehnologies component!");
            assertTrue(isPresentTechnology(tehnology), "Technology " + tehnology + " is not added to the list.");
        }
    }
}
