package com.eurotech.tests.day14_PropertiesSingleton;

import org.testng.annotations.Test;

public class InstantiateSingletonClassExample {

    @Test
    public void test1() {
//        SingletonClassExample singleton = new SingletonClassExample();

        SingletonClassExample singleton1 = SingletonClassExample.getInstanceOfSingletonClassExample();

        SingletonClassExample singleton2 = SingletonClassExample.getInstanceOfSingletonClassExample();

    }




}
