package com.eurotech.tests.day2_webDriver_basic;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateDemo {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //Waiting method
        Thread.sleep(2000);

        driver.navigate().to("https://www.facebook.com");

        Thread.sleep(2000);

        //goes back to previous page
        driver.navigate().back();

        Thread.sleep(2000);
        //goes to forward
        driver.navigate().forward();

        //refresh the page
        driver.navigate().refresh();

        Thread.sleep(2000);
        driver.close();
    }
}
