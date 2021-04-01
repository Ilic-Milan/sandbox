package com.htec.test;

import com.htec.pageobject.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class PeopleTest extends BaseTest {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private PlaygroundPage playgroundPage;
    private SenioritiesComponent senioritiesComponent;
    private NewSeniorityPage newSeniorityPage;
    private TehnologiesComponent tehnologiesComponent;
    private NewTehnologyPage newTehnologyPage;
    private PeopleComponent peopleComponent;
    private NewPersonPage newPersonPage;

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
    public void createPeopleTest() throws InterruptedException {
        playgroundPage = homePage.openPlayground();
        assertTrue(playgroundPage.isAt(), "User is not on Playground page!");

        tehnologiesComponent = playgroundPage.getTehnologiesComponent();
        assertTrue(tehnologiesComponent.isAt(), "User is not on Tehnologies component!");
        if(!tehnologiesComponent.isPresentTehnology()) {
            newTehnologyPage = tehnologiesComponent.goToNewTehnologyForm();
            newTehnologyPage.createTehnology();
        }

        senioritiesComponent = playgroundPage.getSenioritiesComponent();
        assertTrue(senioritiesComponent.isAt(), "User is not on Seniorities component!");
        if(!senioritiesComponent.isPresentSeniority()) {
            newSeniorityPage = senioritiesComponent.goToNewSeniorityForm();
            newSeniorityPage.createSeniority();
        }

        peopleComponent = playgroundPage.getPeopleComponent();
        assertTrue(peopleComponent.isAt(), "User is not on People component!");
        newPersonPage = peopleComponent.goToNewPersonForm();
        newPersonPage.createPeople();
    }
}
