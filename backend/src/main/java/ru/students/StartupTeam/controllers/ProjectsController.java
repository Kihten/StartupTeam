package ru.students.StartupTeam.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.students.StartupTeam.dto.ProjectDTO;
import ru.students.StartupTeam.services.ProjectsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectsController {

    private final ProjectsService projectsService;

    @GetMapping()
    public ResponseEntity<List<ProjectDTO>> getAll(@RequestParam(defaultValue = "0") int pageNo,
                                                   @RequestParam(defaultValue = "10") int pageSize) {
        return projectsService.findAll(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> show(@PathVariable("id") int id) {
        return projectsService.findOne(id);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid ProjectDTO projectDTO,
                                 BindingResult bindingResult) {
        return projectsService.create(projectDTO, bindingResult);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid ProjectDTO projectDTO,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        return projectsService.update(id, projectDTO, bindingResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        return projectsService.delete(id);
    }
}
