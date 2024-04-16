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

public class NoSelectDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }


    @Test
    public void testName() {

        driver.get("https://demo.aspnetawesome.com/");
        //verify that size is 25
        //print all list
        //verify that 4, element is banana
        //click Cherry
        //verify that Cherry is selected

        WebElement dropdownBtn = driver.findElement(By.xpath("(//div[@class='o-slbtn'])[5]"));

        dropdownBtn.click();

        List<WebElement> listDropdown = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[5]/li"));

        System.out.println("listDropdown.size() = " + listDropdown.size());

        Assert.assertEquals(listDropdown.size(),25);

        for (WebElement fruits : listDropdown) {
            System.out.println("fruits.getText() = " + fruits.getText());

        }
        String actualText=listDropdown.get(3).getText();
        String expectedText="Banana";
        Assert.assertEquals(actualText,expectedText,"Verify  that 4. Element is Banana");


        listDropdown.get(4).click();

        WebElement selectedElement = driver.findElement(By.xpath("(//div[@class='o-cptn'])[5]"));
        Assert.assertEquals(selectedElement.getText(),"Cherry");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
