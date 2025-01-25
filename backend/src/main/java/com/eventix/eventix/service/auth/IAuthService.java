package com.eventix.eventix.service.auth;

import com.eventix.eventix.domain.User;
import com.eventix.eventix.model.dto.LoginDTO;
import com.eventix.eventix.model.dto.ResponseDTO;

public interface IAuthService {
    public ResponseDTO register(User user) throws Exception;
    public ResponseDTO login(LoginDTO login);
    public ResponseDTO logout(String token);
}