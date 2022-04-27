package com.example.spring.entities;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

//lombok
//Preco nepouzit pri entity
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Interior extends Project {
    protected Long id;
    protected String name;
    protected Double price;
    protected LocalDate date;
    protected String description;
}
