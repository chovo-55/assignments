package Creational.Prototype;

public class B extends Vitamin {
    public B(){
        type = "B";
    }

    @Override
    void draw() {
        System.out.println("Vitamin B");
    }
}
