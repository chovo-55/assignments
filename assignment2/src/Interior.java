import java.util.Date;

public class Interior extends Project{
    protected double price;
    protected String description;

    public Interior(long id, String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project type: Interior " +
                "| name='" + name + '\'' +
                "| description='" + description + '\'' +
                "| id=" + id +
                "| price=" + price +
                "| dateOfCreation=" + dateOfCreation;
    }
}
