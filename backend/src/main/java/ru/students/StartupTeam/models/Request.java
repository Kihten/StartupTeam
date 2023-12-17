package ru.students.StartupTeam.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Request")
public class Request {
    // TODO: реализовать возможность отправлять запросы на добавление в команду проекта
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
}
