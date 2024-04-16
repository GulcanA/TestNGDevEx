package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_in");
        driver.findElement(By.id("accept-cookie-notification")).click();
        Faker faker = new Faker();
        Thread.sleep(2000);
        driver.findElement(By.name("user[login]")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("user[password]")).sendKeys(faker.internet().password());

        driver.findElement(By.name("commit")).click();

        Thread.sleep(2000);
        driver.close();
    }
}
