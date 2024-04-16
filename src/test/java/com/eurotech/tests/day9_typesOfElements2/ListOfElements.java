package com.eurotech.tests.day9_typesOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> listItems = driver.findElements(By.xpath("//a[text()='A/B Testing']/../../li/a"));
//        List<WebElement> listItems = driver.findElements(By.xpath("//li")); // this is also possible, but initial locator stronger as you have reference point in case a page structure changes in the future

        int expectedSize = 44;
        int actualSize = listItems.size();

        // verify the total number of options
        Assert.assertEquals(actualSize, expectedSize, "Verifying there are " + expectedSize + " items");

        // print all the items in list
        for(WebElement item : listItems){
            System.out.println("item.getText() = " + item.getText());
        }

        // iterate over list items and click the "Checkboxes"
        String itemToClick = "Checkboxes";
        for(WebElement item : listItems){
            if(itemToClick.equals(item.getText())){
                System.out.println("Item to click '" + itemToClick + "' found, will click");
                item.click();
                Thread.sleep(2000);
                break;
            }
        }


    }

    @Test
    public void test2() {
        // navigate "https://demoqa.com/elements"
        // Elements list - verify the size=9
        // print out all the options
        // assert every option is displayed on the page

        driver.get("https://demoqa.com/elements");
        List<WebElement> listItems = driver.findElements(By.xpath("//span[text()='Text Box']/../../li"));
        int expectedSize=9;
        int actualSize = listItems.size();
        Assert.assertEquals(actualSize,expectedSize, "Verifying there are '" + expectedSize + "' options");

        for (WebElement item:listItems) {
            System.out.println(item.getText());
            Assert.assertTrue(item.isDisplayed());
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
      //  driver.close();
    }
}
