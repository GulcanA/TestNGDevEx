package com.eurotech.tests.day12_actions_JS;

import com.beust.ah.A;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
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

public class ActionTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {

        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));

        //Actions ---> class that contains all the user interactions


        Actions actions = new Actions(driver);
        actions.moveToElement(img1).perform();


        //perform() --> perform the action complete the action
        //moveToElement() -- > move your mouse to web element (hover over)

        WebElement view_profile = driver.findElement(By.linkText("View profile"));
        System.out.println("view_profile.getText() = " + view_profile.getText());

        Assert.assertEquals(view_profile.getText(),"View profile");

    }

    @Test
    public void test2BrowserUtils() {
        Driver.get().get("https://the-internet.herokuapp.com/hovers");

        WebElement img1 = Driver.get().findElement(By.xpath("(//img)[2]"));

        BrowserUtils.hover(img1);

        WebElement view_profile = Driver.get().findElement(By.linkText("View profile"));
        System.out.println("view_profile.getText() = " + view_profile.getText());

        Assert.assertEquals(view_profile.getText(),"View profile");

    }

    @Test
    public void dragAndDrop() {

        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();


        WebElement droppedMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        //verify 1 way
     //   Assert.assertTrue(droppedMessage.isDisplayed());

        //verify 2 way
        Assert.assertEquals(droppedMessage.getText(),"Dropped!","Verify that element has dropped");


        
    }

    @Test
    public void DragAndDrop2() {

        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();


        WebElement droppedMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        //verify 1 way
        Assert.assertTrue(droppedMessage.isDisplayed());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
