package Units;

import java.time.LocalDate;

public class Custom extends Common {
    protected String garage;
    protected String heatingType;
    protected String heatingSource;

    public Custom(Long id, String name, Double price, Double area, LocalDate date, String garage, String heatingType, String heatingSource) {
        super(id, name, price, area, date);
        this.garage = garage;
        this.heatingType = heatingType;
        this.heatingSource = heatingSource;
    }

    public String getGarage() {
        return garage;
    }
    public void setGarage(String garage) {
        this.garage = garage;
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

    @Override
    public String toString() {
        return "Custom{" +
                "area=" + area +
                ", heatingSource='" + heatingSource + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
