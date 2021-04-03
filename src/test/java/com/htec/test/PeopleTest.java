package com.htec.test;

import com.htec.pageobject.*;
import com.htec.util.StringGenerator;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class PeopleTest extends BaseTest {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
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
        dashboardPage = new DashboardPage(driver);
    }

    @BeforeMethod
    public void setUpInitialTestState() {
        landingPage.goTo();
        assertTrue(landingPage.isAt(), "User is not on Landing page!");

        landingPage.openLoginForm();
        assertTrue(loginPage.isAt(), "User is not on Login page!");

        loginPage.login(config.getSandboxUsername(), config.getSandboxPassword());
        assertTrue(dashboardPage.isAt(), "User is not Logged in!");

        playgroundPage = dashboardPage.openPlayground();
        assertTrue(playgroundPage.isAt(), "User is not on Playground page!");
    }

    @AfterMethod
    public void logoutUser() {
        dashboardPage.logout();
        assertTrue(landingPage.isAt(), "User is not on Landing page!");
    }

    @Test(dataProvider = "getData", priority = 1)
    public void createPeopleTest(String fullname) throws InterruptedException {

        //Creating Technology if doesn't exist
        tehnologiesComponent = playgroundPage.getTehnologiesComponent();
        assertTrue(tehnologiesComponent.isAt(), "User is not on Tehnologies component!");
        if(!tehnologiesComponent.isPresentAnyTehnology()) {
            newTehnologyPage = tehnologiesComponent.goToNewTehnologyForm();
            String tehnology = newTehnologyPage.createTehnology();
            assertTrue(tehnologiesComponent.isAt(), "User is not on Tehnologies component!");
            assertTrue(tehnologiesComponent.isPresentTechnology(tehnology), "Technology " + tehnology + " is not added to the list.");
        }

        //Creating Seniority if doesn't exist
        senioritiesComponent = playgroundPage.getSenioritiesComponent();
        assertTrue(senioritiesComponent.isAt(), "User is not on Seniorities component!");
        if(!senioritiesComponent.isPresentAnySeniority()) {
            newSeniorityPage = senioritiesComponent.goToNewSeniorityForm();
            String seniority = newSeniorityPage.createSeniority();
            assertTrue(senioritiesComponent.isAt(), "User is not on Seniorities component!");
            assertTrue(senioritiesComponent.isPresentSeniority(seniority), "Seniority " + seniority + " is not added to the list.");
        }

        //Creating Person include technology and seniority
        peopleComponent = playgroundPage.getPeopleComponent();
        assertTrue(peopleComponent.isAt(), "User is not on People component!");
        newPersonPage = peopleComponent.goToNewPersonForm();
        newPersonPage.createPerson(fullname);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {StringGenerator.getRandomFullName()},
                {StringGenerator.getRandomFullName()},
                {StringGenerator.getRandomFullName()}
        };
    }

    @Test(priority = 2)
    public void editPeopleTest() {

        peopleComponent = playgroundPage.getPeopleComponent();
        assertTrue(peopleComponent.isAt(), "User is not on People component!");
        assertTrue(peopleComponent.switchNameAndLastName(), "People list is not updated correctly!");
    }

    @Test(priority = 3)
    public void deletePeopleTest() {

        peopleComponent = playgroundPage.getPeopleComponent();
        assertTrue(peopleComponent.isAt(), "User is not on People component!");
        assertTrue(peopleComponent.deletePeople(), "People list is not deleted correctly!");
    }
}
