package com.eurotech.tests.day6_cssSelector;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssSelectorTest {

    public static void main(String[] args) throws InterruptedException {

        // setup up browser
        // navigate to http://eurotech.study/login
        // locate email, password, login button with CSS
        // enter email value (eurotech@gmail.com), password value (Test12345!) and click login button
        // close the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://eurotech.study/login");

        WebElement email = driver.findElement(By.cssSelector("#loginpage-input-email"));
        WebElement password = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        WebElement acceptCookiesButton = driver.findElement(By.cssSelector("button[aria-label^='Accept']"));

        acceptCookiesButton.click();
        System.out.println("accepted cookies...");

        email.sendKeys("eurotech@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("Test12345!");
        Thread.sleep(1000);

        loginButton.click();
        Thread.sleep(1000);

        driver.close();

    }

}
