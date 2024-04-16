package com.eurotech.tests.day20_DDF;

import com.eurotech.Pages.DashboardPage;
import com.eurotech.Pages.LoginPage;
import com.eurotech.Pages.ProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider extends TestBase {

    @DataProvider
    public Object[][] testData(){
        String[][] data = {
                {"Game of Thrones", "9"},
                {"Sherlock Holmes", "8.5"},
                {"Breaking Bad", "8.5"},
                {"Viking", "8.5"},
                {"Friends", "8.5"},
                {"Big Bang Theory", "8.5"},
                {"Young Sheldon", "8.5"},
                {"Sneaky Pete", "8.5"},
        };
        return data;
    }

    @Test(dataProvider = "testData")
    public void testTvShow(String tvShow, String rating){
        System.out.println("TV Show '" + tvShow + "' has IMDB rating of " + rating);
    }

    @DataProvider
    public Object[][] userData(){
        String[][] data = {
                {"eurotech@gmail.com", "Test12345!"},
                {"baho@gmail.com", "bahobaho"},
                {"gulcan@gmail.com", "newjob2023"}
        };
        return data;
    }


    @Test(dataProvider = "userData")
    public void loginWithUserData(String username, String password) {
        // initialize page objects
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        // name the test case to be shown in report
        extentLogger = report.createTest("Verify user info");

        extentLogger.info("Navigating to the url http://eurotech.study/login");
        driver.get(ConfigurationReader.get("url"));

        // Login Page

        extentLogger.info("Click I understand button");
        loginPage.iUnderstandButton.click();

        extentLogger.info("Enter username");
        loginPage.usernameInput.sendKeys(username);

        extentLogger.info("Enter password");
        loginPage.passwordInput.sendKeys(password);

        extentLogger.info("Click Login button");
        loginPage.loginButton.click();

        // Dashboard Page

        extentLogger.info("Verify that user succesfully logged in");
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());

        extentLogger.pass("Passed");
    }
}
