package com.htec.test;

import com.htec.configuration.Configuration;
import com.htec.driver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    protected final Configuration config = new Configuration();
    protected static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    @BeforeClass
    public void setUp() throws Exception {
        driver = DriverFactory.setDriver(config.getBrowserName());
        driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getImplicitWaitTime()), TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }



}
