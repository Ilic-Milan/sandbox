package com.htec.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PeopleComponent extends BasePage {

    @FindBy(xpath = "//b[contains(text(), 'People')]")
    private WebElement peopleTitle;
    @FindBy(css = "a[href='/create-person']")
    private WebElement createPerson;
    @FindBy(css = ".list-group-item")
    private List<WebElement> people;

    public PeopleComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return waitForIsDisplayed(peopleTitle);
    }

    public NewPersonPage goToNewPersonForm() {
        waitForIsDisplayedAndGetElement(createPerson).click();
        return new NewPersonPage(driver);
    }

    public boolean isPresentPeople() {
        return people.size() != 0;
    }

    public EditPersonPage openEditPersonForm(WebElement person) {
        waitForIsDisplayedAndGetElement(person).click();
        return new EditPersonPage(driver);
    }

    public boolean switchNameAndLastName() {

        int listSize = driver.findElements(By.cssSelector(".list-group-item")).size();

        for (int i = 0; i < listSize; i++) {

            WebElement element = driver.findElements(By.cssSelector(".list-group-item")).get(i);
            String oldNameValue = element.getText();
            EditPersonPage editPerson = openEditPersonForm(element);
            assertTrue(editPerson.isAt(), "User is not on Edit page!");
            String newNameValue = editPerson.flipNameAndLastName(oldNameValue);

            assertTrue(this.isAt(), "User is not on People component page!");
            List<WebElement> refreshedList = driver.findElements(By.cssSelector(".list-group-item"));

            boolean isNewNameVisible = false;
            for (int j = 0; j < refreshedList.size(); j++) {
                if(refreshedList.get(j).getText().equals(newNameValue)) {
                    isNewNameVisible = true;
                    break;
                }
            }
            assertTrue(isNewNameVisible, "New name value " + newNameValue + " is not visible in updated people list.");

            boolean isOldNameVisible = false;
            for (int j = 0; j < refreshedList.size(); j++) {
                if(refreshedList.get(j).getText().equals(oldNameValue)) {
                    isOldNameVisible = true;
                    break;
                }
            }
            assertFalse(isOldNameVisible, "Old name value " + oldNameValue + " should not be visible in updated people list.");
        }
        return true;
    }

    public boolean deletePeople() {

        Iterator<WebElement> iterator = driver.findElements(By.cssSelector(".list-group-item")).iterator();

        while(iterator.hasNext()) {
            WebElement element = iterator.next();
            String deletedPerson = element.getText();
            EditPersonPage editPerson = openEditPersonForm(element);
            assertTrue(editPerson.isAt(), "User is not on Edit page!");

            editPerson.deleteEntity();
            assertTrue(this.isAt(), "User is not on People component page!");

            List<WebElement> refreshedList = driver.findElements(By.cssSelector(".list-group-item"));

            boolean isDeletedPersonVisible = false;
            for (int j = 0; j < refreshedList.size(); j++) {
                if(refreshedList.get(j).getText().equals(deletedPerson)) {
                    isDeletedPersonVisible = true;
                    break;
                }
            }
            assertFalse(isDeletedPersonVisible, "Deleted person " + deletedPerson + " should not be visible in updated people list.");
            iterator.remove();
            iterator = driver.findElements(By.cssSelector(".list-group-item")).iterator();
        }
        return true;
    }

}
