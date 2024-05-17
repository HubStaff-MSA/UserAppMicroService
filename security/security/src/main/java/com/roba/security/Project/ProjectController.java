package com.roba.security.Project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/project")
public record ProjectController(ProjectService projectService) {

    @PostMapping
    public void createProject(@RequestBody ProjectCreationRequest projectRequest){
        System.out.printf("new project added {}", projectRequest);
        projectService.createProject(projectRequest);
    }
    @PutMapping
    public void editProject(@RequestBody ProjectEditRequest projectRequest){
        //log.info("project edited {}", projectRequest);
        projectService.editProject(projectRequest);
    }
    @GetMapping
    public Optional<Project> findById(@RequestParam Integer id){
        //log.info("find project {}", id);
        return projectService.findById(id);
    }


//    @GetMapping("/{managerId}")
//    public List<Project> findByManagerId(@PathVariable Integer managerId){
//        //log.info("find project {}", id);
//        return projectService.findAllByManager(managerId);
//    }
    @DeleteMapping
    public void deleteProject(@RequestParam Integer id){
        //log.info("project deleted {}", id);
        projectService.deleteProject(id);
    }

}