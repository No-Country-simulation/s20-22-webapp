package com.eventix.eventix.service.user;

import com.eventix.eventix.enums.Role;
import com.eventix.eventix.model.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long userId);
    List<UserDTO> getUserByRole(Role role);
    List<UserDTO> getUserByNameAndLastName(String firstName, String lastName);
    UserDTO updateUser(Long userId, UserDTO userDTO);
    void deleteUser(Long userId);
}