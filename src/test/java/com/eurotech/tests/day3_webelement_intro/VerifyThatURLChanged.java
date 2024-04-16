package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLChanged {
    public static void main(String[] args) throws InterruptedException {



        //open the chrome browser
        //enter email address as "eurotech@gmail.com"
        //enter password as "Test12345!"
        //click login button
        //verify that URL has changed my url is /login

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        Thread.sleep(2000);

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        String email = "eurotech@gmail.com";
        String password = "Test12345!";

        WebElement emailInput = driver.findElement(By.id("loginpage-input-email"));
        emailInput.sendKeys(email);
        //second Way
       // emailInput.sendKeys("eurotech@gmail.com");

        WebElement passwordInput= driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        //url should be changed

        //verify that URL has changed
        String expectedUrl= "http://eurotech.study/dashboard";
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
