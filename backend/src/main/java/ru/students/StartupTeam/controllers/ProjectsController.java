package ru.students.StartupTeam.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.students.StartupTeam.dto.ProjectDTO;
import ru.students.StartupTeam.models.project.Project;
import ru.students.StartupTeam.services.ProjectsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectsController {

    private final ProjectsService projectsService;

    @GetMapping()
    public ResponseEntity<List<ProjectDTO>> getAll(@RequestParam(defaultValue = "0") int pageNo,
                                                   @RequestParam(defaultValue = "1") int pageSize) {
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

//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("project", projectsService.findOne(id));
//        return "projects/edit";
//    }

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
