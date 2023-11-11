package ru.students.StartupTeam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "project_name")
    @Size(min = 2, max = 100, message = "Имя проекта должно быть в пределах от 2 до 100 символов")
    @NotNull(message = "Имя проекта должно быть заполнено")
    @NotBlank(message = "Имя проекта должно быть заполнено")
    private String projectName;
    @Column(name = "project_info")
    private String projectInfo;
    @Column(name = "created_at")
    private Date createdAt;

    public Project() {
    }

    public Project(String projectName, String projectInfo) {
        this.projectName = projectName;
        this.projectInfo = projectInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(String projectInfo) {
        this.projectInfo = projectInfo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", projectInfo='" + projectInfo + '\'' +
                '}';
    }
}
