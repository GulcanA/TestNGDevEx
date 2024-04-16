package com.eurotech.tests.day9_typesOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        WebElement colorDropdown = driver.findElement(By.cssSelector("#oldSelectMenu"));

        Select select = new Select(colorDropdown);
        // verify there are 11 colors in this dropdown
        // print all the colors

        List<WebElement> colorOptions = select.getOptions();
        int expectedSize = 11;
        int actualSize = colorOptions.size();


        Assert.assertEquals(actualSize, expectedSize, "verifying there are '" + expectedSize + "' colors");
        
        for(WebElement colorOption : colorOptions){
            System.out.println("colorOption.getText() = " + colorOption.getText());
        }

        // verify the initial color /default color is Red
        String expectedDefaultColor = "Red";
        String actualDefaultColor = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDefaultColor, expectedDefaultColor, "Verifying default color is Red");

        // select Yellow by visibleText and verify it has been selected
        select.selectByVisibleText("Yellow");
        Thread.sleep(1000);
        Assert.assertTrue("Yellow".equals(select.getFirstSelectedOption().getText()), "verifying Yellow is selected");

        // select Green by index and verify it has been selected
        select.selectByIndex(2);
        Thread.sleep(1000);
        Assert.assertTrue("Green".equals(select.getFirstSelectedOption().getText()), "verifying Green is selected");

        // select Indigo by value and verify it has been selected
        select.selectByValue("8");
        Thread.sleep(1000);
//        Assert.assertTrue("Indigo".equals(select.getFirstSelectedOption().getText()), "verifying Indigo is selected");
        String expected = "Indigo";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertTrue(actual.equals(expected));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
