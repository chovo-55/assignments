package com.example.spring.service;

import com.example.spring.repository.Common;
import com.example.spring.repository.Project;
import com.example.spring.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getProject() {
        return projectRepository.findAll();
    }

    public void saveCheck(Project project, Optional var) {
        if (var.isPresent()) {
            throw new IllegalStateException("taken");
        }
        projectRepository.save(project);
    }

    public void deleteCommon(Long projectId){
        boolean exists = projectRepository.existsById(projectId);
        if (!exists){
            throw new IllegalStateException("does not exists!");
        }
        projectRepository.deleteById(projectId);
    }

    public void addNewCommon(Common common) {
        Optional<Common> commonByName = projectRepository.commonFindByName(common.getName());
        saveCheck(common, commonByName);
    }

    public void updateCommonName(Long projectId, String name) {
    }

    /*public void addNewCustom(Custom custom) {
        Optional<Custom> customFindByName = projectRepository.customFindByName(custom.getName());
        saveCheck(custom,customFindByName);
    }

    public void addNewInterior(Interior interior) {
        Optional<Interior> InteriorFindByName = projectRepository.InteriorFindByName(interior.getName());
        saveCheck(interior,InteriorFindByName);
    }*/
}
