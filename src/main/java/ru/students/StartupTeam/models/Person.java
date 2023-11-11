package ru.students.StartupTeam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    @Size(min = 2, max = 50, message = "Имя должно быть в пределах от 2 до 50 символов")
    @NotBlank(message = "Имя должно быть заполнено")
    @NotEmpty(message = "Имя должно быть заполнено")
    private String firstName;
    @Column(name = "surname")
    @Size(min = 2, max = 50, message = "Фамилия должна быть в пределах от 2 до 50 символов")
    @NotBlank(message = "Фамилия должно быть заполнено")
    @NotEmpty(message = "Фамилия должно быть заполнено")
    private String surName;
    @Column(name = "person_info")
    private String personInfo;
    @Column(name = "created_at")
    private Date createdAt;

    public Person() {
    }

    public Person(String firstName, String surName, Date createdAt) {
        this.firstName = firstName;
        this.surName = surName;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(String personInfo) {
        this.personInfo = personInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
