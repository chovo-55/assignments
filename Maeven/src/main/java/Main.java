import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       /* Generics<String, Integer> obj = new Generics<>();
        obj.printType("1", 123);*/

        List <Person> people = new ArrayList<>();

        people.add(new Person("Dano", 100));
        people.add(new Person("Peto", 20));
        people.add(new Person("Fero", 342));
        people.add(new Person("Stevo", 6442));
        people.add(new Person("Adrian", 5442));

        List <Person> B100 = people.stream()
                .filter(person -> person.billions>=100)
                .sorted(Comparator.comparing(Person::getBillions))
                .collect(Collectors.toList());

        System.out.println("allMatch: "+people.stream().allMatch(person -> person.getBillions()>1));

        System.out.println("anyMatch: "+people.stream().anyMatch(person -> person.name.equals("Dano")));

        B100.forEach(person -> System.out.println(person.name));

    }
}
