package com.eurotech.tests.day19_Review;

import com.eurotech.Pages.DashboardPage;
import com.eurotech.Pages.LoginPage;
import com.eurotech.Pages.ProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {

    //    Task:
//    Login as a teacher
//    Verify that login is successful
//    Click Edit Profile button
//    Verify that Github name is "eurotech2023"
//    Click on Go Back button
//    Verify that users job title is "Test Automation Engineer" where the company is Apple
//    Make sure to generate a test report with step logs as well

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProfilePage profilePage;

    @Test
    public void userInfo() {
        // initialize page objects
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        profilePage = new ProfilePage();

        // name the test case to be shown in report
        extentLogger = report.createTest("Verify user info");

        extentLogger.info("Navigating to the url http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

        // Login Page

        extentLogger.info("Click I understand button");
        loginPage.iUnderstandButton.click();

        extentLogger.info("Enter username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("userTeacher"));

        extentLogger.info("Enter password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("userPassword"));

        extentLogger.info("Click Login button");
        loginPage.loginButton.click();

        // Dashboard Page

        extentLogger.info("Verify that user succesfully logged in");
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());

        extentLogger.info("Click Edit Profile button");
        dashboardPage.navigateMenu("Edit Profile");

        // Profile page
        String expectedGithubUsername = "eurotech2023";
        String actualGithubUsername = profilePage.githubUsername.getAttribute("value");
        extentLogger.info("Verify that Github username is " + expectedGithubUsername);
        Assert.assertEquals(actualGithubUsername, expectedGithubUsername);

        extentLogger.info("Click Go Back button");
        profilePage.goBackButton.click();

        // back in Dashboard Page
        extentLogger.info("Verify that Job Title is Test Automation Engineer");
        String expectedJobTitle = "Test Automation Engineer";
        String actualJobTitle = dashboardPage.jobTitle.getText();
        Assert.assertEquals(actualJobTitle, expectedJobTitle);

        extentLogger.pass("Passed");

    }



}
