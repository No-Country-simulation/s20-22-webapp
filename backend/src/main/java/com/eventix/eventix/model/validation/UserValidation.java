package com.eventix.eventix.model.validation;

import com.eventix.eventix.domain.User;
import com.eventix.eventix.model.dto.ResponseDTO;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserValidation {

    private static final Pattern EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
    private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$";

    public ResponseDTO validate(User user) {
        ResponseDTO response = new ResponseDTO();

        if (user.getEmail() == null || !EMAIL_REGEX.matcher(user.getEmail()).matches()) {
            response.setMessage("El correo no tiene formato válido");
            response.setSuccess(false);
            return response;
        }

        if (user.getPassword() == null || !user.getPassword().matches(PASSWORD_REGEX)) {
            response.setMessage("La contraseña debe tener entre 8 y 16 caracteres, al menos un número, una minúscula y una mayúscula.");
            response.setSuccess(false);
            return response;
        }

        response.setSuccess(true);
        return response;
    }
}
