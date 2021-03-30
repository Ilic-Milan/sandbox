package com.htec.test;

import com.htec.driver.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    protected WebDriver driver;
    protected static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    @BeforeTest
    public void setUp() throws Exception {
        driver = DriverManager.setDriver("chrome");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
