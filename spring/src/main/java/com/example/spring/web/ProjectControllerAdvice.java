package com.example.spring.web;


import com.example.spring.exceptions.ProjectAlreadyExistsException;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = ProjectController.class)
public class ProjectControllerAdvice {

    @ExceptionHandler
    public HttpEntity<Object> handleAlreadyExistingProject(ProjectAlreadyExistsException e) {
        return new HttpEntity<>(e.getMessage());
    }

}
