package com.company;

/**
 * 单例模式，懒汉
 */
public class LazySingleton {

    private LazySingleton(){
        System.out.println("LazySingleton is created");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance(){
        if(instance == null)
            instance = new LazySingleton();
        return instance;
    }
}