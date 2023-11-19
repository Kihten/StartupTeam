package ru.students.StartupTeam.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.students.StartupTeam.models.project.Project;
import ru.students.StartupTeam.services.ProjectsService;

@Controller
@RequestMapping("")
public class ProjectsController {

    private final ProjectsService projectsService;

    @Autowired
    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("projects", projectsService.findAll());
        return "projects/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("project", projectsService.findOne(id));
        return "projects/show";
    }

    @GetMapping("/new")
    public String newProject(@ModelAttribute("project") Project project){
        return "projects/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("project") @Valid Project project,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "projects/new";

        projectsService.save(project);
        return "redirect:/projects";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("project", projectsService.findOne(id));
        return "projects/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("project") @Valid Project project, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "/projects/edit";

        projectsService.update(id, project);
        return "redirect:{id}";
    }

    @DeleteMapping
    public String delete(@PathVariable("id") int id){
        projectsService.delete(id);
        return "redirect:projects";
    }
}
