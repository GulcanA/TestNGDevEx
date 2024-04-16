package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW {

    public static void main(String[] args) throws InterruptedException {

//        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        driver.get("https://www.wikipedia.org");
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//
//        driver.findElement(By.xpath("//*[@id='searchInput']")).sendKeys("selenium web driver");
//        driver.findElement(By.xpath("//*[text()='Search']")).click();
//        driver.findElement(By.xpath("//a[@title='Selenium (software)']")).click();
//
//        Thread.sleep(2000);
//        String actualTitle = driver.getTitle();
//        String actualUrl = driver.getCurrentUrl();
//
//        if(actualTitle.toLowerCase().contains("selenium")){
//            System.out.println("Title contains Selenium");
//        }else{
//            System.out.println("Title failed");
//        }
//
//        if(actualUrl.endsWith("Selenium_(software)")){
//            System.out.println("URL ends with \"Selenium_(software)\"");
//        }else{
//            System.out.println("URL failed");
//        }


    /*
    Test Case 1
    open the browser
    go to Ebay
    write selenium in search box
    verify that results contains selenium


     */


    /*
    Test Case 2
    go to ETSY
    search selenium
    click on search button
    print number of results
     */

        //USE XPATH LOCATOR ONLY
    /*

     Test Case 2 (Optinal)
    Go to vikipedia
    enter search "selenium web driver"
    click on search button
    click on Selenium Software
    verify that title contains Selenium
    and verify that URL ends with "Selenium_(software)"

     */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");

        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@id=\"gh-ac-box2\"]/input[1]")).sendKeys("Selenium");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@class=\"btn btn-prim gh-spr\"]")).click();
        for (int i = 2; i < 15; i++) {
            System.out.println(driver.findElement(By.xpath("(//span[@role=\"heading\"])["+ i +"]")).getText().toLowerCase().contains("selenium"));
        }
        driver.close();


    }

}