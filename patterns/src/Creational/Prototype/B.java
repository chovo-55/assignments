package Creational.Prototype;

public class B extends Vitamins{
    public B(){
        type = "B";
    }

    @Override
    void draw() {
        System.out.println("Vitamin B");
    }
}
