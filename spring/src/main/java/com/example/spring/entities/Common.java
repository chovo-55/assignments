package com.example.spring.entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity

public class Common extends Project {
    protected Double area;

    public Common(String name, Double price, LocalDate date, Double area) {
        super(name, price, date);
        this.name = name;
        this.price = price;
        this.date = date;
        this.area = area;
    }

    public Common() {

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
