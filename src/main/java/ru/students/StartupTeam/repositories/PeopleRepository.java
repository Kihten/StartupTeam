package ru.students.StartupTeam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.students.StartupTeam.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
