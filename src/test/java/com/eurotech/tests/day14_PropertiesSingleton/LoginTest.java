package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Task:
 * Declare WebDriver object  at the class level
 * Create a setUp method (@BeforeMethod) where you initialize the driver
 * Create a test method (@Test) where you login by reading url and credentials from properties file
 * Create a tearDown method (@AfterMethod) where you close the driver
 */

public class LoginTest extends TestBase {


    @Test
    public void testName() {
        driver.get(ConfigurationReader.get("url"));

        WebElement iUnderstandButton = driver.findElement(By.id("rcc-confirm-button"));
        WebElement usernameInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("loginpage-form-btn"));

        iUnderstandButton.click();
        usernameInput.sendKeys(ConfigurationReader.get("userTeacher"));
        passwordInput.sendKeys(ConfigurationReader.get("userPassword"));
        loginButton.click();
    }



}
