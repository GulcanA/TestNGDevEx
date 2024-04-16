package com.eurotech.tests.day7_testNG;

import org.testng.annotations.*;

public class testNGAnnotations {

    @Test
    public void test3() {
        System.out.println("this is test3");
    }

    @Test
    public void test1() {
        System.out.println("this is test1");
    }

    @Test
    public void test2() {
        System.out.println("this is test2");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("setting up browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("closing the browser");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("this is before class method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("this is after class method");
    }


}


