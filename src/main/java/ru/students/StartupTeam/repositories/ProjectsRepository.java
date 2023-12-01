package ru.students.StartupTeam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.students.StartupTeam.models.project.Project;

@Repository
public interface ProjectsRepository extends JpaRepository<Project, Integer> {
}
