package ru.students.StartupTeam.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.students.StartupTeam.dto.AuthenticationRequest;
import ru.students.StartupTeam.dto.RegisterRequest;
import ru.students.StartupTeam.services.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> performRegistration(@RequestBody @Valid RegisterRequest request, BindingResult bindingResult) {
        return authenticationService.register(request, bindingResult);
    }

    @PostMapping("/login")
    public ResponseEntity<?> performLogin(@RequestBody @Valid AuthenticationRequest request, BindingResult bindingResult) {
        return authenticationService.authenticate(request, bindingResult);
    }
}
