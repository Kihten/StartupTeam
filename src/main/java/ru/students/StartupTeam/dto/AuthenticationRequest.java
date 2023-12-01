package ru.students.StartupTeam.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    @Email(message = "Значение должно иметь формат адреса электронной почты")
    @NotEmpty(message = "Адрес электронной почты не может быть пустым")
    @NotNull(message = "Адрес электронной почты не может быть пустым")
    private String email;
    @NotNull(message = "Пароль не может быть пустым")
    @NotEmpty(message = "Пароль должен быть заполнен")
    private String password;
}
