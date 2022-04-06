package Creational.Prototype;

public class Main {
    public static void main(String[] args) {
        Cache.loadCache();

        Vitamins clonedVitamins = (Vitamins) Cache.getType(1L);
        System.out.println("Vitamin : " + clonedVitamins.getType());

        Vitamins clonedVitamins2 = (Vitamins) Cache.getType(2L);
        System.out.println("Vitamin : " + clonedVitamins2.getType());
    }
}
