package com.eventix.eventix.controller;

import com.eventix.eventix.domain.User;
import com.eventix.eventix.model.dto.LoginDTO;
import com.eventix.eventix.model.dto.ResponseDTO;
import com.eventix.eventix.service.auth.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/register")
    private ResponseEntity<ResponseDTO> register(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(authService.register(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO login) {
        ResponseDTO response = authService.login(login);

        if (response.getMessage() != null && !response.getMessage().isEmpty()) {
            if ("Usuario no registrado.".equals(response.getMessage()) || "Contraseña inválida.".equals(response.getMessage())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<ResponseDTO> logout(@RequestHeader("Authorization") String authorizationHeader) {
        ResponseDTO response = new ResponseDTO();
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            response.setMessage("Token no proporcionado o formato incorrecto.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        String token = authorizationHeader.substring(7); // "Bearer " -> 7 caracteres
        response = authService.logout(token);

        if ("Cierre de sesión exitoso.".equals(response.getMessage())) {
            return ResponseEntity.ok(response);
        } else if ("El token ya está invalidado.".equals(response.getMessage())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}