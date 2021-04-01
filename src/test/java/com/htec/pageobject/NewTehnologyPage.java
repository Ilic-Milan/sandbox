package com.htec.pageobject;

import com.htec.util.StringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTehnologyPage extends BasePage {

    @FindBy(xpath = "//b[contains(text(), 'New Tehnology')]")
    private WebElement newTehnologyTitle;
    @FindBy(name = "technology_title")
    private WebElement tehnologyTitle;
    @FindBy(css = "button[type = 'submit']")
    private WebElement submitBtn;

    public NewTehnologyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(newTehnologyTitle);
    }

    public void createTehnology() {
        populateField(waitForIsDisplayedAndGetElement(tehnologyTitle), StringGenerator.getRandomTehnologyTitle());
        waitForIsDisplayedAndGetElement(submitBtn).click();
    }
}
