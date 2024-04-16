package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextLocator {
    public static void main(String[] args) throws InterruptedException {

        //open the browser
        //navigate to dynamic loading
        //click Example 1
        //verify that text is "Example 1: Element on page that is hidden"

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");


        WebElement example1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        example1.click();

        WebElement text = driver.findElement(By.tagName("h4"));
        String actualText = text.getText();

        String expectedText ="Example 1: Element on page that is hidden";

        if (expectedText.equals(actualText)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }


        Thread.sleep(2000);
        driver.close();
    }
}
