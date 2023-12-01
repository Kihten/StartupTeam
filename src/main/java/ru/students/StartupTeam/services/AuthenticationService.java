package ru.students.StartupTeam.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ru.students.StartupTeam.dto.AuthenticationRequest;
import ru.students.StartupTeam.dto.RegisterRequest;
import ru.students.StartupTeam.models.Person;
import ru.students.StartupTeam.repositories.PeopleRepository;
import ru.students.StartupTeam.util.RegistrationValidator;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final RegistrationValidator registrationValidator;

    @Transactional
    public ResponseEntity<?> register(RegisterRequest request, BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();
        response.put("requestType", "Регистрация");

//        if (request.getEmail() == null || request.getEmail().isEmpty()){
//            response.put("success", false);
//            response.put("message", "Адрес электронной почты не может быть пустым");
//            return ResponseEntity.badRequest().body(response);
//        }
//
//        if (request.getPassword() == null || request.getPassword().isEmpty()){
//            response.put("success", false);
//            response.put("message", "Пароль не может быть пустым");
//            return ResponseEntity.badRequest().body(response);
//        }

        Person person = convertToPerson(request);

        registrationValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            response.put("success", false);
            response.put("message", bindingResult.getFieldError().getDefaultMessage()); // TODO: получать все сообщения об ошибках
            return ResponseEntity.badRequest().body(response);
        }

        person.setPassword(passwordEncoder.encode(request.getPassword()));
        person.setRole("ROLE_USER");
        person.setCreatedAt(LocalDateTime.now());

        peopleRepository.save(person);

        String token = jwtService.generateJwtToken(person.getEmail());

        response.put("success", true);
        response.put("message", "Пользователь зарегистрирован");
        response.put("person", person);
        response.put("jwtToken", token);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> authenticate(AuthenticationRequest request, BindingResult bindingResult) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        Map<String, Object> response = new HashMap<>();
        response.put("requestType", "Авторизация");

        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            response.put("success", false);
            response.put("message", e.getLocalizedMessage());
            return ResponseEntity.badRequest().body(response);
        }

        String token = jwtService.generateJwtToken(request.getEmail());

        response.put("success", true);
        response.put("message", "Пользователь авторизован");
        response.put("person", request.getEmail());
        response.put("jwtToken", token);
        return ResponseEntity.ok(response);
    }

    public Person convertToPerson(RegisterRequest request) {
        return this.modelMapper.map(request, Person.class);
    }

}
