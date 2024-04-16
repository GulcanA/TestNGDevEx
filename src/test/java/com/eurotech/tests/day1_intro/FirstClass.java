package com.eurotech.tests.day1_intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {

    public static void main(String[] args) {

        System.out.println("Hello Automation!");

        Faker faker = new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.animal().name());

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

    }


}
