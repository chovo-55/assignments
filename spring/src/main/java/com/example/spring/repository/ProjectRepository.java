package com.example.spring.repository;

import com.example.spring.entities.Common;
import com.example.spring.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


    @Query("SELECT s FROM Common s WHERE s.name = ?1")
    Optional<Common> commonFindByName(String name);

   /* @Query("SELECT s FROM Custom s WHERE s.name = ?1")
    Optional<Custom> customFindByName(String name);

    @Query("SELECT s FROM Interior s WHERE s.name = ?1")
    Optional<Interior> InteriorFindByName(String name);*/
}
