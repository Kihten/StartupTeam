package ru.students.StartupTeam.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.students.StartupTeam.dto.PersonDTO;
import ru.students.StartupTeam.services.PeopleService;

@RestController
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleService peopleService;
//    @GetMapping("/profile")
//    public PersonDTO showProfile(){
//        return peopleService.findByEmail(email);
//    }
}
