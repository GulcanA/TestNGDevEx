package com.eurotech.tests.day18_ExtentReports;

import com.eurotech.Pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {

    LoginPage loginPage;

    @Test
    public void wrongUsername() {
        loginPage = new LoginPage();
        //name of the test
        extentLogger = report.createTest("Wrong Username Test");

        extentLogger.info("Navigate to the url 'http://eurotech.study/login'");
        driver.get(ConfigurationReader.get("url"));

        // test steps
        extentLogger.info("Click I understand button");
        loginPage.iUnderstandButton.click();

        extentLogger.info("Enter wrong/invalid username");
        loginPage.usernameInput.sendKeys("eurot@gmail.com");

        extentLogger.info("Enter valid password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("userPassword"));

        extentLogger.info("Click login button");
        loginPage.loginButton.click();

        String actualMessage = loginPage.warningMessage.getText();

        extentLogger.info("Verify that user cannot login");
        Assert.assertEquals(actualMessage, "Invalid Credentials!", "Verifying the warning message");

        extentLogger.pass("Passed");
    }


    @Test
    public void wrongPassword() {
        // Task
        // navigate 'http://eurotech.study/login'
        // enter valid username but invalid password
        // validate user cannot login

        loginPage = new LoginPage();

        //name of the test
        extentLogger = report.createTest("Wrong Password Test");

        extentLogger.info("Navigate to the url 'http://eurotech.study/login'");
        driver.get(ConfigurationReader.get("url"));

        // test steps
        extentLogger.info("Click I understand button");
        loginPage.iUnderstandButton.click();

        extentLogger.info("Enter valid username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("userTeacher"));

        extentLogger.info("Enter wrong/invalid password");
        loginPage.passwordInput.sendKeys("123456");

        extentLogger.info("Click login button");
        loginPage.loginButton.click();

        String actualMessage = loginPage.warningMessage.getText();

        extentLogger.info("Verify that user cannot login");
        Assert.assertEquals(actualMessage, "Invalid Credentials!", "Verifying the warning message");

        extentLogger.pass("Passed");
    }
}
