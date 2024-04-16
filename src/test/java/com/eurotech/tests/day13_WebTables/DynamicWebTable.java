package com.eurotech.tests.day13_WebTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicWebTable {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void dynamicNegative() {

        driver.get("https://demoqa.com/webtables");
        WebElement kierra = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[3]/div/div[1]"));
        System.out.println("Before Click "+ kierra.getText());

        driver.findElement(By.xpath("//*[text()='Last Name']")).click();

        System.out.println("After Click "+kierra.getText());


    }

    @Test
    public void dynamicPositive() {
        driver.get("https://demoqa.com/webtables");

        WebElement kierra = driver.findElement(By.xpath("//*[text()='Kierra']"));
        System.out.println("Before Click "+ kierra.getText());

        driver.findElement(By.xpath("//*[text()='Last Name']")).click();

        kierra = driver.findElement(By.xpath("//*[text()='Kierra']"));
        System.out.println("After Click "+kierra.getText());
        Assert.assertEquals(kierra.getText(),"Kierra");
    }

    @Test
    public void dynamic2() {
        driver.get("file:///Users/erhanilgar/Downloads/WebTable.html");
        WebElement maryCountry = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));
        System.out.println("Before Click = " + maryCountry.getText());

        driver.findElement(By.xpath("//th[text()='Email']")).click();

        maryCountry = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));
        System.out.println("After Click = " + maryCountry.getText());
        Assert.assertEquals(maryCountry.getText(),"Canada");

    }

    @Test
    public void dynamic3() {
        driver.get("file:///Users/erhanilgar/Downloads/WebTable.html");
        WebElement maryCountry = driver.findElement(By.xpath("//td[text()='Mary']/../td[3]"));
        System.out.println("Before Click = " + maryCountry.getText());

        WebElement emailBtn = driver.findElement(By.xpath("//th[text()='Email']"));
        emailBtn.click();
        driver.findElement(By.xpath("//th[text()='Name']")).click();

        maryCountry = driver.findElement(By.xpath("//td[text()='Mary']/../td[3]"));
        System.out.println("After Click = " + maryCountry.getText());

        Assert.assertEquals(maryCountry.getText(),"Canada");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
