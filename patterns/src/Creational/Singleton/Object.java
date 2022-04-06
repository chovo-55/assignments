package Creational.Singleton;

public class Object {
    private static Object instance = new Object();
    private Object(){}

    public static Object getInstance(){
        return instance;
    }

    public void message(){
        System.out.println("Hello World!");
    }
}
