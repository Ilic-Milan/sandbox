package com.htec.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver setDriver(String browser) throws Exception {
        return DriverManager.getDriver(browser);
    }

}
