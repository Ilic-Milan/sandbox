package com.htec.test;

import com.htec.configuration.Configuration;
import com.htec.driver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    protected WebDriver driver;
    protected final Configuration config = new Configuration();
    protected static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    @BeforeTest
    public void setUp() throws Exception {
        driver = DriverFactory.setDriver(config.getBrowserName());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
