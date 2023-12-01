package ru.students.StartupTeam.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Specialization")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
}
