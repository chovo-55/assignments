package com.example.spring.entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Custom extends Project {
    protected double area;
    protected String garage;
    protected String heatingType;
    protected String heatingSource;

    public Custom(String name, Double price, LocalDate date, Double area, String garage, String heatingType, String heatingSource) {
        super(name, price, date);
        this.area = area;
        this.garage = garage;
        this.heatingType = heatingType;
        this.heatingSource = heatingSource;
    }

    public Custom() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
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