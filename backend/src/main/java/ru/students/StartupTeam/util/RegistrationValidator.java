package ru.students.StartupTeam.util;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.students.StartupTeam.models.Person;
import ru.students.StartupTeam.services.UserDetailsServiceImpl;

@Component
@RequiredArgsConstructor
public class RegistrationValidator implements Validator {

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        try {
            userDetailsService.loadUserByUsername(person.getEmail());
        } catch (UsernameNotFoundException ignored) {
            return;
        }

        errors.rejectValue("email", "", "Пользователь с данной почтой уже зарегистрирован!");
    }
}
