package com.htec.test;

import com.htec.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = DriverManager.setDriver("chrome");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    protected void click() {

    }

}
