package ru.students.StartupTeam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import ru.students.StartupTeam.models.project.Project;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Size(min = 2, max = 50, message = "Имя должно быть в пределах от 2 до 50 символов")
    @Column(name = "first_name")
    private String firstName;
    @Size(min = 2, max = 50, message = "Фамилия должна быть в пределах от 2 до 50 символов")
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "person_info")
    private String personInfo;
    @Column(name = "role")
    private String role;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "author")
    private List<Project> projects;
    @ManyToMany
    @JoinTable(
            name = "Person_Skill",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;
}
