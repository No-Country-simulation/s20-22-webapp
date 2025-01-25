package com.eventix.eventix.service;

import com.eventix.eventix.domain.User;
import com.eventix.eventix.model.dto.UserDTO;
import com.eventix.eventix.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements IUserService{


    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDto(savedUser);
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