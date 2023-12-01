package ru.students.StartupTeam.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.students.StartupTeam.models.project.Project;
import ru.students.StartupTeam.repositories.ProjectsRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectsService {

    private final ProjectsRepository projectsRepository;

    public List<Project> findAll() {
        return projectsRepository.findAll();
    }

    public Project findOne(int id) {
        Optional<Project> foundProject = projectsRepository.findById(id);
        return foundProject.orElse(null);
    }

    @Transactional
    public void save(Project project) {
        project.setCreatedAt(LocalDateTime.now());
        projectsRepository.save(project);
    }

    @Transactional
    public void update(int id, Project updatedProject) {
        // Потом пригодится для установления связи с пользователем
//        Project projectToBeUpdated = projectsRepository.findById(id).get();

        updatedProject.setId(id);
        updatedProject.setCreatedAt(LocalDateTime.now());
        projectsRepository.save(updatedProject);
    }

    @Transactional
    public void delete(int id) {
        projectsRepository.deleteById(id);
    }
}
