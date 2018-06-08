package com.company;

/**
 * 静态内部类创建
 */
public class InnerClassSingleton {
    private InnerClassSingleton(){
        System.out.println("InnerClassSingleton is created");
    }

    private static class SingletonHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public InnerClassSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
