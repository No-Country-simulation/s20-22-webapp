package com.eventix.eventix.service.auth;

import com.eventix.eventix.domain.User;
import com.eventix.eventix.model.dto.LoginDTO;
import com.eventix.eventix.model.dto.ResponseDTO;
import com.eventix.eventix.model.validation.UserValidation;
import com.eventix.eventix.repository.UserRepository;
import com.eventix.eventix.service.jwt.IJwtUtilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final UserRepository userRepository;
    private final IJwtUtilityService jwtUtilityService;
    private final UserValidation userValidation;
    private final TokenBlacklistService tokenBlacklistService;

    @Override
    public ResponseDTO register(User user) throws Exception {
        ResponseDTO response = userValidation.validate(user);

        if (!response.isSuccess()) {
            return response;
        }

        try {
            Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
            if (existingUser.isPresent()) {
                response.setMessage("Usuario ya existe con el correo " + user.getEmail());
                response.setSuccess(false);
                return response;
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);

            response.setMessage("Usuario registrado con éxito.");
            response.setSuccess(true);
        } catch (Exception e) {
            response.setMessage("Error en el registro: " + e.getMessage());
            response.setSuccess(false);
        }

        return response;
    }

    @Override
    public ResponseDTO login(LoginDTO login) {
        ResponseDTO response = new ResponseDTO();
        try {
            Optional<User> user = userRepository.findByEmail(login.getEmail());
            if (user.isEmpty()) {
                response.setMessage("Usuario no registrado.");
                return response;
            }
            if (verifyPassword(login.getPassword(), user.get().getPassword())) {
                String token = jwtUtilityService.generateJWT(user.get().getUserId());
                response.setJwt(token);
            } else {
                response.setMessage("Contraseña inválida.");
            }
        } catch (Exception e) {
            response.setMessage("Error en el proceso de autenticación: " + e.getMessage());
        }
        return response;
    }

    @Override
    public ResponseDTO logout(String token) {
        ResponseDTO response = new ResponseDTO();
        try {
            tokenBlacklistService.blacklistToken(token);
            response.setMessage("Cierre de desión exitoso.");
        } catch (Exception e) {
            response.setMessage("Error durante el cierre de sesión: " + e.getMessage());
        }
        return response;
    }

    private boolean verifyPassword (String enterPassword, String storedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enterPassword, storedPassword);
    }
}