package com.eurotech.tests.day1_intro;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

      //  WebDriver driver =new FirefoxDriver();


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.co.uk/");

        driver.close();




    }


}
