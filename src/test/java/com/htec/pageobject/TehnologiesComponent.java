package com.htec.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TehnologiesComponent extends BasePage {

    @FindBy(xpath = "//b[contains(text(), 'Technologies')]")
    private WebElement tehnologiesTitle;
    @FindBy(css = "a[href='/create-technology']")
    private WebElement createTehnology;
    @FindBy(css = ".list-group-item.list-group-item-action")
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
        waitForIsDisplayedAndGetElement(createTehnology).click();
        return new NewTehnologyPage(driver);
    }

    public boolean isPresentTehnology() {
        return tehnologies.size() !=0;
    }

}
