package Behavioral.Strategy;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new Adder());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new Multiplyer());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
