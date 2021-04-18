package com.htec.test;

import com.htec.configuration.Configuration;
import com.htec.driver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {

    protected WebDriver driver;
    protected final Configuration config = new Configuration();
    protected static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    @BeforeMethod
    public void beforeMethod() {
        LOGGER.info("=============================== START TEST CASE ===============================");
    }

    @AfterMethod
    public void afterMethod() {
        LOGGER.info("=============================== END TEST CASE ===============================");
    }

    @BeforeClass
    public void setUp() throws Exception {
        LOGGER.info("=============================== LAUNCHING WEBDRIVER ===============================");
        driver = DriverFactory.setDriver(config.getBrowserName());
    }

    @AfterClass
    public void tearDown() {
        LOGGER.info("=============================== CLOSING WEBDRIVER ===============================");
        driver.quit();
    }



}
