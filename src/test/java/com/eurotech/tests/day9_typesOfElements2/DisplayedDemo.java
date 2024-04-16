package com.eurotech.tests.day9_typesOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");


        // navigate to the url
        // verify that "Hello World!" text is not displayed on the page
        // click Start button
        // verify that "Hello World!" text is displayed on the page


        WebElement example1 = driver.findElement(By.xpath("//a[contains(text(),'Example 1: Element on')]"));
        example1.click();

        Thread.sleep(1000);

        WebElement helloWorld = driver.findElement(By.xpath("//h4[.='Hello World!']"));

        Assert.assertFalse(helloWorld.isDisplayed(),
                "verify that 'Hello World!' text is not displayed on the page");

        WebElement startButton = driver.findElement(By.xpath("//button[.='Start']"));
        startButton.click();

        Thread.sleep(5000);

        Assert.assertTrue(helloWorld.isDisplayed(),
                "verify that 'Hello World!' text is displayed on the page");

        driver.close();

    }
}
