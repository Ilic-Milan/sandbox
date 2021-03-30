package com.htec.pageobject;

import com.htec.configuration.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Configuration config = new Configuration();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Long.parseLong(config.getImplicitWaitTime()));
    }



}
