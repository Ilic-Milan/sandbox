package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class NewPersonPage extends BasePage {

    @FindBy(xpath = "//b[contains(text(), 'New Person')]")
    private WebElement newPersonTitle;
    @FindBy(name = "people_name")
    private WebElement fullName;
    @FindBy(css = "input[placeholder = 'Select technologies']")
    private WebElement selectTehnologies;
    @FindBy(css = ".react-dropdown-select-dropdown")
    private WebElement dropdownSelect;
    @FindBy(css = "span[aria-label]")
    private List<WebElement> dropdownList;
    @FindBy(css = "span[role='listitem']")
    private WebElement selectedTechnology;
    @FindBy(css = "input[placeholder = 'Select seniority']")
    private WebElement selectSeniority;
    @FindBy(css = "button[type = 'submit']")
    private WebElement submitBtn;


    public NewPersonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void chooseTechnology() {
        waitForIsDisplayedAndGetElement(selectTehnologies).click();
        waitForIsDisplayed(dropdownSelect);
        if(dropdownList.size() > 0) {
            waitForIsDisplayedAndGetElement(dropdownList.get(new Random().nextInt(dropdownList.size()))).click();
        }else{
            LOGGER.warn("There is no available technology!");
        }
        waitForIsDisplayed(selectedTechnology);
        waitForIsDisplayed(dropdownSelect);
        waitForIsDisplayedAndGetElement(fullName).click();
    }

    public void chooseSeniority() {
        waitForIsDisplayedAndGetElement(selectSeniority).click();
        waitForIsDisplayed(dropdownSelect);
        if(dropdownList.size() > 0) {
            waitForIsDisplayedAndGetElement(dropdownList.get(new Random().nextInt(dropdownList.size()))).click();
        }else{
            LOGGER.warn("There is no available seniority!");
        }
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(newPersonTitle);
    }

    public void createPerson(String fullname) {
        populateField(waitForIsDisplayedAndGetElement(fullName), fullname);
        chooseTechnology();
        chooseSeniority();
        waitForIsDisplayedAndGetElement(submitBtn).click();
    }
}
