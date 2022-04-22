package com.example.spring.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {
    List<Student> list = new ArrayList();

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student Dano = new Student("Dano","dano@gmail.com", LocalDate.of(2000, Month.JANUARY,6),22);
            Student Peto = new Student("Peto","Peto@gmail.com", LocalDate.of(2002, Month.FEBRUARY,16),23);
            list.add(Dano);
            list.add(Peto);
            repository.saveAll(list);
        };
    }
}
