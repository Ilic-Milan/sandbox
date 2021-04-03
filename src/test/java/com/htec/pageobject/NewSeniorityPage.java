package com.htec.pageobject;

import com.htec.util.StringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewSeniorityPage extends BasePage {

    @FindBy(css = "//b[contains(text(), 'New Seniority')]")
    private WebElement newPersonTitle;
    @FindBy(name = "seniority_title")
    private WebElement seniorityTitle;
    @FindBy(css = "button[type = 'submit']")
    private WebElement submitBtn;

    public NewSeniorityPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(newPersonTitle);
    }

    public String createSeniority() {
        String title = StringGenerator.getRandomSeniorityTitle();
        populateField(waitForIsDisplayedAndGetElement(seniorityTitle), title);
        waitForIsDisplayedAndGetElement(submitBtn).click();
        return title;
    }
}
