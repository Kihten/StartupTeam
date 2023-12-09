package ru.students.StartupTeam.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.students.StartupTeam.models.project.Project;
import ru.students.StartupTeam.services.ProjectsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectsController {

    private final ProjectsService projectsService;

    @GetMapping()
    public List<Project> index() {
        return projectsService.findAll();
    }

    @GetMapping("/{id}")
    public Project show(@PathVariable("id") int id) {
        return projectsService.findOne(id);
    }

    @GetMapping("/new")
    public Project newProject(@RequestBody Project project) {
        return project;
    }

    @PostMapping()
    public String create(@ModelAttribute("project") @Valid Project project,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "projects/new";

        projectsService.save(project);
        return "redirect:/projects";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("project", projectsService.findOne(id));
        return "projects/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("project") @Valid Project project, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "/projects/edit";

        projectsService.update(id, project);
        return "redirect:{id}";
    }

    @DeleteMapping
    public String delete(@PathVariable("id") int id) {
        projectsService.delete(id);
        return "redirect:projects";
    }
}
