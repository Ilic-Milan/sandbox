package com.htec.test;

import com.htec.pageobject.LandingPage;
import com.htec.pageobject.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SandboxTest extends BaseTest {

    private LandingPage landingPage;
    private LoginPage loginPage;

    @BeforeTest
    public void setupPages() {
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void firstTest() {
        this.landingPage.goTo();
        this.landingPage.openLoginForm();
    }

}
