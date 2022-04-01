import java.util.Date;

public class Common extends Project{
    protected double area;

    public Common(long id, String name, double area, double price) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Project type: Common " +
                "| name='" + name + '\'' +
                "| id=" + id +
                "| area=" + area +
                "| price=" + price +
                "| dateOfCreation=" + dateOfCreation;
    }
}
