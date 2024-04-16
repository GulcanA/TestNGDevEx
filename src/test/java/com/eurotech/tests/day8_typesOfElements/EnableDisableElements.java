package com.eurotech.tests.day8_typesOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableDisableElements {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement textBox = driver.findElement(By.cssSelector("#input-example>input"));

        Assert.assertFalse(textBox.isEnabled(), "Verifying textBox is disabled");

        WebElement enableDisableButton = driver.findElement(By.cssSelector("#input-example>button"));

        enableDisableButton.click();

        Thread.sleep(3000);

        Assert.assertTrue(textBox.isEnabled(), "Verifying textBox is enabled");

        driver.close();
    }

}
