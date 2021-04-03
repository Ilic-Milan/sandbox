package com.htec.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        return new ChromeDriver();
    }

    public static WebDriver getDriver(String browser) throws Exception {
        switch (browser) {
            case "chrome":
                return getChromeDriver();
            case "firefox":
                return getFirefoxDriver();
            default:
                throw new Exception("Missing browser parameter!");
        }
    }

}
