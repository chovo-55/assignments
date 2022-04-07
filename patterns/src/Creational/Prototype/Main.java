package Creational.Prototype;

public class Main {
    public static void main(String[] args) {
        Cache.loadCache();

        Vitamin clonedVitamins = (Vitamin) Cache.getType(1L);
        System.out.println("Vitamin : " + clonedVitamins.getType());

        Vitamin clonedVitamins2 = (Vitamin) Cache.getType(2L);
        System.out.println("Vitamin : " + clonedVitamins2.getType());
    }
}
