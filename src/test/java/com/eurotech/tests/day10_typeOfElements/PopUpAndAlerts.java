package com.eurotech.tests.day10_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void popUp() throws InterruptedException {

        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=50eaa");
        driver.findElement(By.xpath("(//span[text()='Confirm'])[1]")).click();
        driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();

        Thread.sleep(1000);

        String expectedMessage ="You have accepted";
        String actualMessage = driver.findElement(By.xpath("//p[text()='You have accepted']")).getText();

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void JSAlerts() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();


        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        alert.dismiss();

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        alert.sendKeys("Eurotech Batch 6");
        Thread.sleep(1000);
        alert.accept();

        //homework
        //verify all results above JS Alerts



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
