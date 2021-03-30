package com.htec.test;

import com.htec.pageobject.HomePage;
import com.htec.pageobject.LandingPage;
import com.htec.pageobject.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeTest
    public void setupPages() {
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void loginPositiveTest() {
        landingPage.goTo();
        assertTrue(landingPage.isAt(), "User is not on Landing page!");

        landingPage.openLoginForm();
        assertTrue(loginPage.isAt(), "User is not on Login page!");

        loginPage.login();
        assertTrue(homePage.isAt(), "User is not Logged in!");
    }

}
