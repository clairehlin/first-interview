package com.first.interview.design.patterns;

// This pattern ensures there is only one instance of the class per JVM
public class SingletonPattern {
    public static void main(String[] args) {
        // you cannot create instances using constructors in singleton
//        MySingleton mySingleton1 = new MySingleton();
//        MySingleton mySingleton2 = new MySingleton();
        // you can only use the static getInstance method
        MySingleton mySingleton1 = MySingleton.getInstance();
        MySingleton mySingleton2 = MySingleton.getInstance();
        System.out.println(mySingleton1);
        System.out.println(mySingleton2);
    }
}

class MySingleton {
    private static MySingleton mySingleton;

    private MySingleton() {
    }

    public synchronized static MySingleton getInstance() {
        if (mySingleton == null) {
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }
}