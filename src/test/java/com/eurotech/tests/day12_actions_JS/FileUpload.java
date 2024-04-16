package com.eurotech.tests.day12_actions_JS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void fileUpload() {

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/erhanilgar/Desktop/EurotechBatch6.rtf");

        //      "C:\\Users\\Misafir\\Desktop\\Eurotech.txt"

        //       "C:/Users/Misafir/Desktop/Eurotech.txt"

        driver.findElement(By.cssSelector("#file-submit")).click();

        String actualText =driver.findElement(By.cssSelector("#uploaded-files")).getText();
        String expectedText ="EurotechBatch6.rtf";
        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void test2() {
        driver.get("https://the-internet.herokuapp.com/upload");
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));


        String projectPath = System.getProperty("user.dir");
        String filePath ="src/test/resources/EurotechBatch6.txt";


        String fullPath= projectPath+"/"+filePath;  ///first mistake
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys(fullPath);
        driver.findElement(By.cssSelector("#file-submit")).click();
        String actualText =driver.findElement(By.cssSelector("#uploaded-files")).getText();
        String expectedText ="EurotechBatch6.txt";
        Assert.assertEquals(actualText,expectedText);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
