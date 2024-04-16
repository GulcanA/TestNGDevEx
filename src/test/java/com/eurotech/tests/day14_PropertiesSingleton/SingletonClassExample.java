package com.eurotech.tests.day14_PropertiesSingleton;

public class SingletonClassExample {

    private static SingletonClassExample instanceOfSingletonClassExample;

    private SingletonClassExample(){
        System.out.println("creating the SingletonClassExample object");
    }

    public static SingletonClassExample getInstanceOfSingletonClassExample(){
        if(instanceOfSingletonClassExample == null){
            instanceOfSingletonClassExample = new SingletonClassExample();
        }else{
            System.out.println("It has already been initialized, returning existing instance of SingletonClassExample");
        }
        return instanceOfSingletonClassExample;
    }

}
