import java.util.Date;

public class Custom extends Project{
    protected String heatingType;
    protected String heatingSource;
    protected String garage;
    protected double area;

    public Custom(String heatingType, String heatingSource, String garage, double area) {
        this.heatingType = heatingType;
        this.heatingSource = heatingSource;
        this.garage = garage;
        this.area = area;
    }

    public String getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(String heatingType) {
        this.heatingType = heatingType;
    }

    public String getHeatingSource() {
        return heatingSource;
    }

    public void setHeatingSource(String heatingSource) {
        this.heatingSource = heatingSource;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Project typ: Custom " +
                "| name='" + name + '\'' +
                "| heatingSource='" + heatingSource + '\'' +
                "| heatingType='" + heatingType + '\'' +
                "| garage='" + garage + '\'' +
                "| id=" + id +
                "| area=" + area +
                "| price=" + price +
                "| dateOfCreation=" + dateOfCreation;
    }
}
