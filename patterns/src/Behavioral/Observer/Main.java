package Behavioral.Observer;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new Observer1(subject);
        new Observer2(subject);

        System.out.println("News");
        subject.setState(15);
        System.out.println("\nnew news");
        subject.setState(10);
    }
}
