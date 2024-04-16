package com.eurotech.tests.day20_DDF;

import com.eurotech.Pages.DashboardPage;
import com.eurotech.Pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {



    @DataProvider
    public Object[][] userData(){
        ExcelUtil testData = new ExcelUtil("src/test/resources/EurotechTest.xlsx", "Test Data");
        return testData.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "userData")
    public void ddfLoginTest(String username, String password, String title, String company, String name) {
        // initialize page objects
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        // name the test case to be shown in report
        extentLogger = report.createTest(name + "'s Login  Test");

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

        extentLogger.info("Verify that title is = " + title);
        Assert.assertEquals(dashboardPage.getCurrentExperienceTitle(), title);

        // Task - Homework
        // validate company value is as given in the Excel file

        extentLogger.info("Verify that "+ name+ "is working at "+company);
        Assert.assertEquals(dashboardPage.getCompanyName(title),company);




        extentLogger.pass("Passed");


    }

}
