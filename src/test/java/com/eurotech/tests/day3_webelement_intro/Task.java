package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task {
    public static void main(String[] args) throws InterruptedException {

        //open chrome browser
        //navigate to "http://eurotech.study/login"
        //enter username and password
        //eurotech@gmail.com password "Test12345!"
        //Verify login successfully
        //Verify that Dashboard text is exist

        //10 min

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        Thread.sleep(2000);
        driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement emailInput = driver.findElement(By.id("loginpage-input-email"));
        emailInput.sendKeys("eurotech@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("Test12345!");

        driver.findElement(By.id("loginpage-form-btn")).click();
        Thread.sleep(1000);

        WebElement dashboard = driver.findElement(By.id("dashboard-h1"));
        System.out.println("dashboard.getText() = " + dashboard.getText());

        String expectedText="Dashboard";
        String actualText = dashboard.getText();

        if(expectedText.equals(actualText)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(1000);
        driver.close();

    }
}
