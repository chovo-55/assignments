package com.example.spring.service;

import com.example.spring.repository.Common;
import com.example.spring.repository.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProject() {
        return projectService.getProject();
    }


    @PostMapping
    public void registerNewCommon(@RequestBody Common common) {
        projectService.addNewCommon(common);
    }

    @DeleteMapping(path = "{projectId}")
    public void deleteCommon(@PathVariable("projectId") Long projectId) {
        projectService.deleteCommon(projectId);
    }

    @PutMapping(path = "projectId")
    public void updateCommon(
        @PathVariable("projectId") Long projectId,
        @PathVariable( required = false) String name){
        projectService.updateCommonName(projectId,name);
    }

    /*@DeleteMapping(path = "{projectId}")
    public void deleteCustom(){
        projectService.deleteCommon(projectId);
    }

    @DeleteMapping(path = "{projectId}")
    public void deleteInterior(){
        projectService.deleteCommon(projectId);
    }*/

    /*@PostMapping
    public void registerNewCustom(@RequestBody Custom custom){
        projectService.addNewCustom(custom);
    }

    @PostMapping
    public void registerNewInterior(@RequestBody Interior interior){
        projectService.addNewInterior(interior);
    }*/
}
