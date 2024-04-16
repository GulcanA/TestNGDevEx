package com.eurotech.tests.day12_actions_JS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavascriptExecutorDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testAmazon() {

        driver.get("https://www.amazon.co.uk/");

        driver.findElement(By.id("sp-cc-accept")).click();
        WebElement turkey = driver.findElement(By.linkText("Turkey"));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", turkey);

    }

    @Test
    public void typeWithJS() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        String text= "Hello Disable Element";

        executor.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {

        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,500)");
        }

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-500)");
        }

    }

    @Test
    public void scrollToElement() {

        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();
        WebElement turkey = driver.findElement(By.linkText("Turkey"));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", turkey);
        executor.executeScript("arguments[0].click();", turkey);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
