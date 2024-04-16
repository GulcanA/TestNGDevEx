package com.eurotech.tests.day8_typesOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        Assert.assertTrue(checkbox2.isSelected(), "Verifying checkbox2 is selected by default");
        Assert.assertFalse(checkbox1.isSelected(), "Verifying checkbox1 is NOT selected by default");

        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected(), "Verifying checkbox1 is selected after clicking");

        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected(), "Verifying checkbox2 is NOT selected after clicking");

        driver.close();

    }
}
