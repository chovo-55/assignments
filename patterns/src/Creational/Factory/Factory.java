package Creational.Factory;

public class Factory {
    public Vitamins getVitamins(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("B")){
            return new B();

        } else if(shapeType.equalsIgnoreCase("C")){
            return new C();

        }
        return null;
    }
}
