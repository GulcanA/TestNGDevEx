package com.eurotech.tests.Day15_POM;

import com.eurotech.Pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void wrongPassword() {
        driver.get(ConfigurationReader.get("url"));

        WebElement iUnderstandButton = driver.findElement(By.id("rcc-confirm-button"));
        WebElement usernameInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("loginpage-form-btn"));


        iUnderstandButton.click();
        usernameInput.sendKeys(ConfigurationReader.get("userTeacher"));
        passwordInput.sendKeys("wrongPassword");
        loginButton.click();

        WebElement warningMessage = driver.findElement(By.xpath("//div[text()='Invalid Credentials!']"));

        // assert warning message is displayed
        Assert.assertTrue(warningMessage.isDisplayed(), "Verifying warning message is displayed upon invalid login");
        //assert warning message = "Invalid Credentials!"
        Assert.assertEquals(warningMessage.getText(), "Invalid Credentials!", "Verifying the warning message equal to 'Invalid Credentials!'");
    }


    @Test
    public void wrongPassword2() {

        driver.get(ConfigurationReader.get("url"));

        loginPage.iUnderstandButton.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("userTeacher"));
        loginPage.passwordInput.sendKeys("wrongPassword");
        loginPage.loginButton.click();

        // assert warning message is displayed
        Assert.assertTrue(loginPage.warningMessage.isDisplayed(), "Verifying warning message is displayed upon invalid login");
        //assert warning message = "Invalid Credentials!"
        Assert.assertEquals(loginPage.warningMessage.getText(), "Invalid Credentials!", "Verifying the warning message equal to 'Invalid Credentials!'");
    }

    @Test
    public void wrongUsername() {

        driver.get(ConfigurationReader.get("url"));

        loginPage.iUnderstandButton.click();
        loginPage.usernameInput.sendKeys("invalidUsername@gmail.com");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("userPassword"));
        loginPage.loginButton.click();

        // assert warning message is displayed
        Assert.assertTrue(loginPage.warningMessage.isDisplayed(), "Verifying warning message is displayed upon invalid login");
        //assert warning message = "Invalid Credentials!"
        Assert.assertEquals(loginPage.warningMessage.getText(), "Invalid Credentials!", "Verifying the warning message equal to 'Invalid Credentials!'");
    }

}
