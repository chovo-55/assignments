package Units;

import java.time.LocalDate;

public class Interior extends Project{
    protected String description;

    public Interior(Long id, String name, Double price, LocalDate date, String description) {
        super(id, name, price, date);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Interior{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
