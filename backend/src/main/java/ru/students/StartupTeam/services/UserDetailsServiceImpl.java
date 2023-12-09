package ru.students.StartupTeam.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.students.StartupTeam.models.Person;
import ru.students.StartupTeam.repositories.PeopleRepository;
import ru.students.StartupTeam.security.UserDetailsImpl;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = peopleRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не был найден!"));

        return new UserDetailsImpl(person);
    }
}
