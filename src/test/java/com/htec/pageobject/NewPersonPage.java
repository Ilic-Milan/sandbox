package com.htec.pageobject;

import com.htec.util.StringGenerator;
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
    private List<WebElement> technologies;
    @FindBy(css = "span[role='listitem']")
    private WebElement selectedTechnology;
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
        waitForIsDisplayedAndGetElement(selectTehnologies).click();
        waitForIsDisplayed(dropdownSelect);
        waitForIsNotDisplayed(selectedTechnology);
        if(technologies.size() > 0) {
            waitForIsDisplayedAndGetElement(technologies.get(new Random().nextInt(technologies.size()))).click();
        }else{
            LOGGER.info("There is no available technologies!");
        }
        waitForIsDisplayed(selectedTechnology);
        waitForIsDisplayed(dropdownSelect);
        waitForIsDisplayedAndGetElement(submitBtn).click();
    }
}
