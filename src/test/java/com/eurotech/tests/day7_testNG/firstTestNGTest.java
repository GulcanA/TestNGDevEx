package com.eurotech.tests.day7_testNG;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class firstTestNGTest {

    @Test
    public void test1(){
        System.out.println("this is my second test");
    }

    @Test
    public void test2()  {
        System.out.println("this is my first test");
    }

    @Test
    public void test3() {
        System.out.println("this is my third test");
    }


}
