public class Person {
    String name;
    Integer billions;

    public Person(String name, Integer billions) {
        this.name = name;
        this.billions = billions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBillions() {
        return billions;
    }

    public void setBillions(Integer billions) {
        this.billions = billions;
    }
}
