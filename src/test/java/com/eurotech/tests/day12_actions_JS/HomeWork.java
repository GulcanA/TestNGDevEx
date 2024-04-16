package com.eurotech.tests.day12_actions_JS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void hover() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");


        for (int i = 2; i <=4 ; i++) {

            String xpathImg= "(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textPath = "//h5[text()='name: user"+(i-1)+"']";
            WebElement text = driver.findElement(By.xpath(textPath));
            System.out.println(textPath);

            Assert.assertTrue(text.isDisplayed(),"verify user"+(i-1)+" is displayed");


        }


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
