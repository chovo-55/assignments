package Units;

import java.time.LocalDate;

public class Common extends Project {
    protected Double area;

    public Common(Long id, String name, Double price, Double area, LocalDate date) {
        super(id, name, price, date);
        this.area = area;
    }

    public Double getArea() {
        return area;
    }
    public void setArea(Double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Common{" +
                "area=" + area +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
