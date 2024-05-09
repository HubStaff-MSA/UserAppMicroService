package com.roba.security.Project;



import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public record ProjectService(ProjectRepository projectRepository) {
    public void createProject(ProjectCreationRequest projectRequest) {
        if (projectRequest.projectName() == null || projectRequest.projectName().isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be empty");
        }
        Project project = Project.builder()
                .projectName(projectRequest.projectName())
                .billable(projectRequest.billable())
                .budgetBasedOn(projectRequest.budgetBasedOn())
                .budgetCost(projectRequest.budgetCost())
                .budgetNotifyAt(projectRequest.budgetNotifyAt())
                .budgetStartDate(projectRequest.budgetStartDate())
                .budgetType(projectRequest.budgetType())
                .client(projectRequest.client())
                //.clientId(projectRequest.clientId())
                .budgetIncludeNonBillabeTime(projectRequest.budgetIncludeNonBillabeTime())
                .disableActivity(projectRequest.disableActivity())
                .disableIdleTime(projectRequest.disableIdleTime())
                .organizationId(projectRequest.organizationId())
                //.budget(projectRequest.budget())
                .build();
        //todo: check constraints
        //todo: fix pgadmin bug
        projectRepository.save(project);
    }
    public void editProject(ProjectEditRequest projectRequest) {
        //Project project = projectRepository.getById(projectRequest.id());
        Project project = Project.builder()
                .id(projectRequest.id())
                .projectName(projectRequest.projectName())
                .billable(projectRequest.billable())
                .budgetBasedOn(projectRequest.budgetBasedOn())
                .budgetCost(projectRequest.budgetCost())
                .budgetNotifyAt(projectRequest.budgetNotifyAt())
                .budgetStartDate(projectRequest.budgetStartDate())
                .budgetType(projectRequest.budgetType())
                //.clientId(projectRequest.clientId())
                .client(projectRequest.client())
                .budgetIncludeNonBillabeTime(projectRequest.budgetIncludeNonBillabeTime())
                .disableActivity(projectRequest.disableActivity())
                .disableIdleTime(projectRequest.disableIdleTime())
                .organizationId(projectRequest.organizationId())
//                .budget(projectRequest.budget())
                .build();
        //todo: check constraints
        //todo: fix pgadmin bug
        projectRepository.save(project);
    }
    public void deleteProject(Integer id){
        try {
            projectRepository.deleteById(id);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete project with id: " + id, e);
        }
    }
    public Optional<Project> findById(Integer id){
        return projectRepository.findById(id);
    }
//    public List<Project> findAllByManager(Integer managerId){
//        return projectRepository.findAllByManagerId(managerId);
//    }
}