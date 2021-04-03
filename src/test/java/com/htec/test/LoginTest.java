package com.htec.test;

import com.htec.pageobject.HomePage;
import com.htec.pageobject.LandingPage;
import com.htec.pageobject.LoginPage;
import org.testng.annotations.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setupPages() {
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
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
        assertTrue(homePage.isAt(), "User is not Logged in!");
    }

    @Test(dataProvider = "getData")
    public void loginNegativeTest(String username, String password) {
        loginPage.login(username, password);
        assertFalse(homePage.isAt(), "User should not be Logged in!");
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
