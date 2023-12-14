package ru.students.StartupTeam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.students.StartupTeam.models.Skill;
import ru.students.StartupTeam.models.Specialization;
import ru.students.StartupTeam.models.project.Project;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDTO {
    private String firstName;
    private String surname;
    private String email;
    private String avatar;
    private String personInfo;
    private Specialization specialization;
    private List<Project> projects;
//    private List<Skill> skills;
    private String token;
}
