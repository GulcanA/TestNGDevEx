package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        System.out.println("Browser: " + ConfigurationReader.get("browser"));

        driver.get(ConfigurationReader.get("url"));
        System.out.println("url: " + ConfigurationReader.get("url"));

        System.out.println("userTeacher = " + ConfigurationReader.get("userTeacher"));

        System.out.println("userPassword = " + ConfigurationReader.get("userPassword"));
    }

    @Test
    public void test2() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        System.out.println("Browser: " + ConfigurationReader.get("browser"));

//        System.out.println("url: " + ConfigurationReader.get("urll"));
        driver.get(ConfigurationReader.get("url"));


        driver.findElement(By.id("rcc-confirm-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys(ConfigurationReader.get("userTeacher"));
        driver.findElement(By.name("password")).sendKeys(ConfigurationReader.get("userPassword") + Keys.ENTER);

//        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(1000);

        String text = driver.findElement(By.className("my-2")).getText();
        System.out.println("text = " + text);


        driver.close();

    }


}
