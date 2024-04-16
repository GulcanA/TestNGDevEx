package com.eurotech.tests.day10_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void iframe() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");

        //first way switching iframe
        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(2000);
        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));

        textArea.clear();
        textArea.sendKeys("Eurotech Was Here");

        //second way
        driver.switchTo().parentFrame();
        driver.switchTo().frame(0);
        textArea.clear();
        textArea.sendKeys("Eurotech Was Here Second way");

        //3 way using web element

        driver.switchTo().parentFrame();
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        textArea.clear();
        textArea.sendKeys("Eurotech Was Here Third way");


    }

    @Test
    public void nestedIframe() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //get text Middle

        //default content

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println("driver.findElement(By.cssSelector(\"#content\")).getText() = " + driver.findElement(By.cssSelector("#content")).getText());


      //  driver.switchTo().parentFrame();
        driver.switchTo().defaultContent(); // it will go to top
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());

        //go to bottom frame and get text

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}

