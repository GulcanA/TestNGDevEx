package com.eurotech.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory {


    //Task
    //write a static method it takes a string parameter (browserType)
    //it will setup browser
    //and this method return type chromedriver or firefoxdriver object (webDriver)
    //name is  getDriver


    public static WebDriver getDriver(String browserType){
        WebDriver driver = null;

        switch (browserType.toLowerCase()){
            case "chrome":
                ChromeOptions co =new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

        }
        return driver;
    }

}
