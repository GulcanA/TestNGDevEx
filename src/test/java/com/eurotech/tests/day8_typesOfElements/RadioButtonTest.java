package com.eurotech.tests.day8_typesOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void testName() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://demo.aspnetawesome.com/");

        // verify that "Vegetables" radio button is selected by default

        Thread.sleep(2000);

        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));

        Assert.assertTrue(vegetablesRadio.isSelected(), "Verifying 'Vegetables' radio button is selected");

        // verify that "Legumes" radio button is NOT selected
        // click "Legumes"
        // verify Legumes is selected
        // verify Vegetables is NOT selected

        WebElement legumesRadio = driver.findElement(By.xpath("//div[text()='Legumes']/../input"));
        Assert.assertFalse(legumesRadio.isSelected(), "Verifying 'Legumes' radio button is NOT selected");
        WebElement legumesClick = driver.findElement(By.xpath("//div[text()='Legumes']/../div[1]"));
        Thread.sleep(5000);
        legumesClick.click();
        Thread.sleep(5000);
       Assert.assertTrue(legumesRadio.isSelected(), "Verifying 'Legumes' radio button is selected");
        Assert.assertFalse(vegetablesRadio.isSelected(), "Verifying 'Vegetables' radio button is NOT selected");

        driver.close();


    }

}
