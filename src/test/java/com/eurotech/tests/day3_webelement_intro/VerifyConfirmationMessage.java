package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {


        //open chrome browser
        // go to "http://eurotech.study/login"
        //enter valid credentials "eurotech@gmail.com" and password "Test12345!"
        //verify that confirmation message is "Welcome Teacher"

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        Thread.sleep(1000);

        driver.findElement(By.id("rcc-confirm-button")).click();

        //enter username
        driver.findElement(By.name("email")).sendKeys("eurotech@gmail.com");

        //enter password
        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys("Test12345!");

        //click login button
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        System.out.println("loginBtn.getAttribute() = " + loginBtn.getAttribute("value"));
        loginBtn.click();
        Thread.sleep(2000);

        WebElement welcomeMessage = driver.findElement(By.id("dashboard-p1"));
        //we have two ways to get text from web pages
        //1. getText() --> it will work %99 and it will return String
        //2. getAttribute() -->
        System.out.println(welcomeMessage.getText());

        String expectedText = "Welcome Teacher";
        String actualText = welcomeMessage.getText();

        if(expectedText.equals(actualText)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }


        driver.close();
    }
}
