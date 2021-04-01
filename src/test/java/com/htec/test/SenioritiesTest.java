package com.htec.test;

import com.htec.pageobject.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SenioritiesTest extends BaseTest {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private PlaygroundPage playgroundPage;
    private SenioritiesComponent senioritiesComponent;
    private NewSeniorityPage newSeniorityPage;

    @BeforeClass
    public void setupPages() {
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void setUpInitialTestState() {
        landingPage.goTo();
        assertTrue(landingPage.isAt(), "User is not on Landing page!");

        landingPage.openLoginForm();
        assertTrue(loginPage.isAt(), "User is not on Login page!");

        loginPage.login(config.getSandboxUsername(), config.getSandboxPassword());
        assertTrue(homePage.isAt(), "User is not Logged in!");
    }

    @Test
    public void createSeniorityTest() {
        playgroundPage = homePage.openPlayground();
        assertTrue(playgroundPage.isAt(), "User is not on Playground page!");

        senioritiesComponent = playgroundPage.getSenioritiesComponent();
        newSeniorityPage = senioritiesComponent.goToNewSeniorityForm();
        newSeniorityPage.createSeniority();
    }
}
