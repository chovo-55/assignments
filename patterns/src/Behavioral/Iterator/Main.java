package Behavioral.Iterator;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();

        for(Iterator iter = repository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }

}
