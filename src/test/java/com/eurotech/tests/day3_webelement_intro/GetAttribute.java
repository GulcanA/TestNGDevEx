package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement emailInput = driver.findElement(By.id("loginpage-input-email"));
        emailInput.sendKeys("Hello World!");
        Thread.sleep(1000);

        System.out.println("emailInput.getAttribute= " + emailInput.getAttribute("value"));


        System.out.println("emailInput.getAttribute(\"placeHolder\") = " + emailInput.getAttribute("placeholder"));
        System.out.println("emailInput.getAttribute(\"id\") = " + emailInput.getAttribute("id"));
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        System.out.println("passwordInput.getAttribute(\"minlength\") = " + passwordInput.getAttribute("minlength"));
        System.out.println("passwordInput.getAttribute(\"type\") = " + passwordInput.getAttribute("type"));


        driver.close();

    }
}
