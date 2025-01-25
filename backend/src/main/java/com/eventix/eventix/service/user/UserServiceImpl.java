package com.eventix.eventix.service.user;

import com.eventix.eventix.domain.User;
import com.eventix.eventix.enums.Role;
import com.eventix.eventix.model.dto.UserDTO;
import com.eventix.eventix.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository IUserRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUsers() {
        return IUserRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = IUserRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + userId));
        return convertToDto(user);
    }

    @Override
    public List<UserDTO> getUserByRole(Role role) {
        return IUserRepository.findByRole(role)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getUserByNameAndLastName(String firstName, String lastName) {
        return IUserRepository.findByFirstNameAndLastName(firstName, lastName)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User existingUser = IUserRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + userId));

        modelMapper.map(userDTO, existingUser);

        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }

        User updatedUser = IUserRepository.save(existingUser);
        return convertToDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = IUserRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + userId));
        IUserRepository.delete(user);
    }

    // Entity to DTO
    private UserDTO convertToDto (User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    // DTO to Entity
    private User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

}