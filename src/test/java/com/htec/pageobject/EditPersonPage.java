package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class EditPersonPage extends BasePage {

    @FindBy(xpath = "//b[contains(text(), 'Edit Person')]")
    private WebElement editPersonTitle;
    @FindBy(name = "people_name")
    private WebElement fullName;
    @FindBy(css = ".delete-button button")
    private WebElement deleteBtn;
    @FindBy(css = ".btn-danger")
    private WebElement popUpDeleteBtn;
    @FindBy(css = "button[type = 'submit']")
    private WebElement submitBtn;

    public EditPersonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(editPersonTitle);
    }

    public String flipNameAndLastName(String oldName) {
        assertEquals(waitForIsDisplayedAndGetElement(fullName).getAttribute("value"), oldName, "Full name is not as expected.");
        fullName.clear();
        String[] splitted = oldName.split(" ");
        String newName = splitted[1] + " " + splitted[0];
        fullName.sendKeys(newName);
        submitBtn.click();
        return newName;
    }

    public void deleteEntity() {
        waitForIsDisplayedAndGetElement(deleteBtn).click();
        waitForIsDisplayedAndGetElement(popUpDeleteBtn).click();
        waitForIsNotDisplayed(popUpDeleteBtn);
    }
}
