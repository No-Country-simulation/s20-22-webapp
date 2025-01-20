package com.eventix.eventix.service;

import com.eventix.eventix.model.dto.UserDTO;

public interface IUserService {
    UserDTO createUser(UserDTO userDTO);
}