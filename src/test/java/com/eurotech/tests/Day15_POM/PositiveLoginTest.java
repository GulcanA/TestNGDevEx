package com.eurotech.tests.Day15_POM;

import com.eurotech.Pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void login() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        loginPage.iUnderstandButton.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("userTeacher"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("userPassword"));
        loginPage.loginButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard", "Verifying that user successfully logged in");
    }

    @Test
    public void loginWithMethod() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        String username = ConfigurationReader.get("userTeacher");
        String password = ConfigurationReader.get("userPassword");
        loginPage.login(username, password);
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard", "Verifying that user successfully logged in");
    }

    @Test
    public void loginWithLoginAsTeacherMethod() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard", "Verifying that user successfully logged in");
    }


    @Test
    public void loginWithLoginAsStudentMethod() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsStudent();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard", "Verifying that user successfully logged in");
    }



}
