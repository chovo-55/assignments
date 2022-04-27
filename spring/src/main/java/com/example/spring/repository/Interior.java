package com.example.spring.repository;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity

public class Interior extends Project {
    protected Long id;
    protected String name;
    protected Double price;
    protected LocalDate date;
    protected String description;

    public Interior( String name, Double price, LocalDate date, String description) {
        super(name, price, date);
        this.description = description;
    }

    public Interior() {

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
