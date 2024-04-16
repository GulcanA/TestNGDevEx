package com.eurotech.tests.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {

    WebDriver driver;




    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void explicitWait1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//*[text()='Start']")).click();

        //How to wait explicitly wait?
        //Create an explicit object wait

        WebDriverWait wait = new WebDriverWait(driver,15);

        WebElement textElement = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(textElement));




        String expectedText ="Hello World!";

        Assert.assertEquals(textElement.getText(),expectedText);
    }

    @Test
    public void explicitWait2() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableBtn = driver.findElement(By.xpath("//button[text()='Enable']"));

        enableBtn.click();

        WebElement inputBox = driver.findElement(By.cssSelector("input[type=text]"));

        WebDriverWait wait = new WebDriverWait(driver,15);

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("Eurotech Was Here");

        WebElement message = driver.findElement(By.cssSelector("#message"));
        Assert.assertEquals(message.getText(),"It's enabled!");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
