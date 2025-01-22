package com.eventix.eventix.model.dto;

import com.eventix.eventix.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotBlank(message = "Nombre es obligatorio")
    private String firstName;

    @NotBlank(message = "Apellido es obligatorio")
    private String lastName;

    @NotBlank(message = "Email es obligatorio")
    @Email(message = "Formato email inválido")
    private String email;

    @NotBlank(message = "Password es obligatorio")
    @Size(min = 8, message = "Password tiene que tener más de 8 caracteres")
    private String password;

    private Role role;
    private Timestamp createdAt;
}