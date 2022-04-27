package com.example.spring.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProjectConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProjectRepository repository){
        return args -> {
            Common common = new Common("common",12.3, LocalDate.now(),3.21);
            Custom custom = new Custom("custom",12.3, LocalDate.now(),3.21,
                    "y","t","S");
            List<Project> list = new ArrayList();
            list.add(common);
            list.add(custom);
            repository.saveAll(list);
        };
    }
}
