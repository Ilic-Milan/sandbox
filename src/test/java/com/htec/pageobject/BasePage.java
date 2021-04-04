package com.htec.pageobject;

import com.htec.configuration.Configuration;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Configuration config = new Configuration();
    protected static final Logger LOGGER = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Long.parseLong(config.getImplicitWaitTime()));
    }

    public abstract boolean isAt();

    protected boolean waitForIsDisplayed(WebElement element, int timeout) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        final WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException exception) {
            LOGGER.warn("Condition is not met!" + "\n" + exception);
            return false;
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getImplicitWaitTime()), TimeUnit.SECONDS);
        return true;
    }

    protected boolean waitForIsDisplayed(WebElement element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException exception) {
            LOGGER.warn("Condition is not met!"  + "\n" + exception);
            return false;
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getImplicitWaitTime()), TimeUnit.SECONDS);
        return true;
    }

    protected boolean waitForIsNotDisplayed(WebElement element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException exception) {
            LOGGER.warn("Condition is not met!"  + "\n" + exception);
            return false;
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getImplicitWaitTime()), TimeUnit.SECONDS);
        return true;
    }

    protected WebElement waitForIsDisplayedAndGetElement(WebElement element) {
        return waitForIsDisplayed(element) ? element : null;
    }

    protected void populateField(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

}
