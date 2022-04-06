package Creational.Factory;

public class Main {
    public static void main(String[] args) {
        Factory vitaminsFactory = new Factory();

        Vitamins vitamins = vitaminsFactory.getVitamins("C");

        vitamins.list();

        Vitamins vitamins2 = vitaminsFactory.getVitamins("B");

        vitamins2.list();
    }
}
