package com.htec.test;

import com.htec.pageobject.DashboardPage;
import com.htec.pageobject.LandingPage;
import com.htec.pageobject.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeClass
    public void setupPages() {
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @BeforeMethod
    public void goToLoginForm() {
        landingPage.goTo();
        assertTrue(landingPage.isAt(), "User is not on Landing page!");

        landingPage.openLoginForm();
        assertTrue(loginPage.isAt(), "User is not on Login page!");
    }

    @Test
    public void loginPositiveTest() {
        loginPage.login(config.getSandboxUsername(), config.getSandboxPassword());
        assertTrue(dashboardPage.isAt(), "User is not Logged in!");
    }

    @Test(dataProvider = "getData")
    public void loginNegativeTest(String username, String password) {
        loginPage.login(username, password);
        assertFalse(dashboardPage.isAt(), "User should not be Logged in!");
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"", ""},
                {"username", ""},
                {"", "password"}
        };
    }

}
