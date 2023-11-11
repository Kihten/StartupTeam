package ru.students.StartupTeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.students.StartupTeam.models.Project;
import ru.students.StartupTeam.repositories.ProjectsRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProjectsService {

    private final ProjectsRepository projectsRepository;

    @Autowired
    public ProjectsService(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    public List<Project> findAll(){
        return projectsRepository.findAll();
    }

    public Project findOne(int id){
        Optional<Project> foundProject = projectsRepository.findById(id);
        return foundProject.orElse(null);
    }

    @Transactional
    public void save(Project project){
        project.setCreatedAt(new Date());
        projectsRepository.save(project);
    }

    @Transactional
    public void update(int id, Project updatedProject){
        // Потом пригодится для установления связи с пользователем
//        Project projectToBeUpdated = projectsRepository.findById(id).get();

        updatedProject.setId(id);
        updatedProject.setCreatedAt(new Date());
        projectsRepository.save(updatedProject);
    }

    @Transactional
    public void delete(int id){
        projectsRepository.deleteById(id);
    }
}
