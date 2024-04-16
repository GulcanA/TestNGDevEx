package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
     //   driver.manage().window().maximize();

        Faker faker = new Faker();
        WebElement userNameInput = driver.findElement(By.id("userName"));

        userNameInput.sendKeys(faker.name().fullName());

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);
        driver.close();

    }
}
