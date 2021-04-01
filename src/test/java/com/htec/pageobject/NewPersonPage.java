package com.htec.pageobject;

import com.htec.util.StringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPersonPage extends BasePage {

    @FindBy(css = "//b[contains(text(), 'New Person')]")
    private WebElement newPersonTitle;
    @FindBy(name = "people_name")
    private WebElement fullName;
    @FindBy(css = "button[type = 'submit']")
    private WebElement submitBtn;


    public NewPersonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(newPersonTitle);
    }

    public void createPeople() {
        populateField(waitForIsDisplayedAndGetElement(fullName), StringGenerator.getRandomFullName());
        waitForIsDisplayedAndGetElement(submitBtn).click();
    }
}
