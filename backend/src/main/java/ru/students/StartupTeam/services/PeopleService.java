package ru.students.StartupTeam.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.students.StartupTeam.dto.PersonDTO;
import ru.students.StartupTeam.models.Person;
import ru.students.StartupTeam.repositories.PeopleRepository;


// TODO: need to change or delete this class
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;
    private final ModelMapper modelMapper;

    public Person findByEmail(String email){
        return peopleRepository.findByEmail(email).orElse(null);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    public PersonDTO convertToPersonDTO(Person person){
        return modelMapper.map(person, PersonDTO.class);
    }

}
