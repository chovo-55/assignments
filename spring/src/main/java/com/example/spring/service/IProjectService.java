package com.example.spring.service;

import com.example.spring.entities.Common;
import com.example.spring.entities.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {

    void saveCheck(Project project, Optional var);

    void deleteCommon(Long projectId);

    void addNewCommon(Common common);

    List<Project> getProject();

    void addProject(Project project);
}
