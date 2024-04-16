package com.eurotech.tests.day9_typesOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.cssSelector("#userName"));

        System.out.println("autocomplete: " + fullName.getAttribute("autocomplete"));
        System.out.println("id: " + fullName.getAttribute("id"));
        System.out.println("placeholder: " + fullName.getAttribute("placeholder"));
        System.out.println("type: " + fullName.getAttribute("type"));
        System.out.println("class: " + fullName.getAttribute("class"));

//        System.out.println("outerHTML: " + fullName.getAttribute("outerHTML"));
//        System.out.println("innerHTML: " + fullName.getAttribute("innerHTML"));

        WebElement fullNameBroad = driver.findElement(By.xpath("//div[@id='userName-wrapper']"));
        System.out.println("outerHTML: " + fullNameBroad.getAttribute("outerHTML"));
        System.out.println("innerHTML: " + fullNameBroad.getAttribute("innerHTML"));


        System.out.println(("Page source - HTML: " + driver.getPageSource()));


        Thread.sleep(1000);
        driver.close();



    }

}
