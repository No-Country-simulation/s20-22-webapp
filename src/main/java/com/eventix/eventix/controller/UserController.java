package com.eventix.eventix.controller;

import com.eventix.eventix.model.dto.UserDTO;
import com.eventix.eventix.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createUser = userService.createUser(userDTO);
        return ResponseEntity.ok(createUser);
    }
}