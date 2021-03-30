package com.htec.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static WebDriver setDriver(String browser) throws Exception {
        return DriverFactory.getDriver(browser);
    }

}
