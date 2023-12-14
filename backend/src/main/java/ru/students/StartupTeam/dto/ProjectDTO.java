package ru.students.StartupTeam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.students.StartupTeam.models.Person;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDTO {
    @Size(min = 2, max = 100, message = "Имя проекта должно быть в пределах от 2 до 100 символов")
    @NotNull(message = "Имя проекта должно быть заполнено")
    @NotBlank(message = "Имя проекта должно быть заполнено")
    private String name;
    private String purpose;
    private String task;
    private String projectInfo;
    private String image;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Person author;
}