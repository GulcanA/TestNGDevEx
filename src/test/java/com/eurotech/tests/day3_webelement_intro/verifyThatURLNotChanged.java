package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyThatURLNotChanged {

    public static void main(String[] args) throws InterruptedException {



        //open chrome browser
        //go to http://eurotech.study/login
        //click login button
        //verify that URL not changed

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        Thread.sleep(2000);

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        //click login button
        String expectedUrl= driver.getCurrentUrl();
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();


        //String expectedUrl= "http://eurotech.study/login";

        //get current URL
        String actualUrl= driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }




        Thread.sleep(2000);

        driver.close();




    }
}
