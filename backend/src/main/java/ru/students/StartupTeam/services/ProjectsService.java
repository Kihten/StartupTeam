package ru.students.StartupTeam.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ru.students.StartupTeam.dto.ProjectDTO;
import ru.students.StartupTeam.models.Project;
import ru.students.StartupTeam.repositories.PeopleRepository;
import ru.students.StartupTeam.repositories.ProjectsRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectsService {

    private final ProjectsRepository projectsRepository;
    private final PeopleRepository peopleRepository;
    public final ModelMapper modelMapper;

    public ResponseEntity<List<ProjectDTO>>  findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("createdAt").descending());
        Slice<ProjectDTO> slicedResult = projectsRepository.findAll(pageable).map(this::convertToProjectDTO);
        List<ProjectDTO> projects = slicedResult.getContent();

        return ResponseEntity.ok(projects);
    }

    public ResponseEntity<ProjectDTO> findOne(int id) {
        Optional<Project> foundProject = projectsRepository.findById(id);
        return ResponseEntity.ok(convertToProjectDTO(foundProject.orElse(null)));
    }

    @Transactional
    public ResponseEntity<?> create(ProjectDTO projectDTO, BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();
        response.put("requestType", "Создание проекта");


        if (bindingResult.hasErrors()) {
            response.put("success", false);
            response.put("message", bindingResult.getFieldError().getDefaultMessage());
            return ResponseEntity.badRequest().body(response);
        }

        Project project = convertToProject(projectDTO);
//        Optional<Person> person = peopleRepository.findByEmail(email);
//        project.setAuthor(peopleRepository.findByEmail());
        project.setCreatedAt(LocalDateTime.now());
        projectsRepository.save(project);

        response.put("success", true);
        response.put("message", "Проект был создан");
        return ResponseEntity.ok(response);
    }


    @Transactional
    public ResponseEntity<?> update(int id, ProjectDTO updatedProjectDTO, BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();
        response.put("requestType", "Обновление проекта");

        Project projectToBeUpdated = projectsRepository.findById(id).get();
        Project updatedProject = convertToProject(updatedProjectDTO);

        if (bindingResult.hasErrors()) {
            response.put("success", false);
            response.put("message", bindingResult.getFieldError().getDefaultMessage());
            return ResponseEntity.badRequest().body(response);
        }

        updatedProject.setId(id);
        updatedProject.setCreatedAt(projectToBeUpdated.getCreatedAt());
        updatedProject.setUpdatedAt(LocalDateTime.now());
        projectsRepository.save(updatedProject);

        response.put("success", true);
        response.put("message", "Данные проекта обновлены");
        return ResponseEntity.ok(response);
    }

    @Transactional
    public ResponseEntity<?> delete(int id) {
        Map<String, Object> response = new HashMap<>();
        response.put("requestType", "Удаление проекта");

        projectsRepository.deleteById(id);

        response.put("success", true);
        response.put("message", "Проект был удален");
        return ResponseEntity.ok(response);
    }

    public ProjectDTO convertToProjectDTO(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }

    public Project convertToProject(ProjectDTO projectDTO) {
        return modelMapper.map(projectDTO, Project.class);
    }
}
