package com.eurotech.tests.day2_webDriver_basic;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class closeAndQuit {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        Thread.sleep(2000);

        //close current tab
        driver.close();

        WebDriver driver1 = new ChromeDriver();
        driver1.get("http://eurotech.study/login");

        Thread.sleep(2000);


        //close all browser (all tabs)
        driver1.quit();


    }
}
