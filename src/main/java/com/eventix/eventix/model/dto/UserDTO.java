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
    /*@NotBlank(message = "First name is required")*/
    private String firstName;

    /*@NotBlank(message = "Last name is required")*/
    private String lastName;

    /*@Email(message = "Invalid email format")*/
    private String email;

    /*@NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")*/
    private String password;

    private Role role;
    private Timestamp createdAt;
}