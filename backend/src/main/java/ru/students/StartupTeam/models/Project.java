package ru.students.StartupTeam.models;

import jakarta.persistence.*;
import lombok.Data;
import ru.students.StartupTeam.models.Person;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "purpose")
    private String purpose;
    @Column(name = "task")
    private String task;
    @Column(name = "project_info")
    private String projectInfo;
    @Column(name = "image")
    private String image;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Person author;
    // TODO: add skills to project
}
