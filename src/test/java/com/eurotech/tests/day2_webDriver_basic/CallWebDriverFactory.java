package com.eurotech.tests.day2_webDriver_basic;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");



        Thread.sleep(2000);
        driver.close();

    }
}
