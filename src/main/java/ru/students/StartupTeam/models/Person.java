package ru.students.StartupTeam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import ru.students.StartupTeam.models.project.Project;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Size(min = 2, max = 50, message = "Имя должно быть в пределах от 2 до 50 символов")
    @NotBlank(message = "Имя должно быть заполнено")
    @NotEmpty(message = "Имя должно быть заполнено")
    @Column(name = "first_name")
    private String firstName;
    @Size(min = 2, max = 50, message = "Фамилия должна быть в пределах от 2 до 50 символов")
    @NotBlank(message = "Фамилия должно быть заполнено")
    @NotEmpty(message = "Фамилия должно быть заполнено")
    @Column(name = "surname")
    private String surname;
    @Email
    @NotEmpty(message = "Электронная поста должна быть заполнена")
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @NotEmpty(message = "Пароль должен быть заполнен")
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

    public Person() {
    }

    public Person(String firstName, String surName, LocalDateTime createdAt) {
        this.firstName = firstName;
        this.surname = surName;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(String personInfo) {
        this.personInfo = personInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
