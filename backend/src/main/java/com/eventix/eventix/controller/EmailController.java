package com.eventix.eventix.controller;

import com.eventix.eventix.model.dto.EventReqDto;
import com.eventix.eventix.model.dto.UserDTO;
import com.eventix.eventix.service.email.IEmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send-email")
@RequiredArgsConstructor
public class EmailController {

    private final IEmailService emailService;

    @PostMapping()
    private ResponseEntity<String> sendEmail(@RequestBody EventReqDto event, UserDTO user) throws MessagingException {
        emailService.sendEmail(event, user);
        return new ResponseEntity<>("Correo enviado exitosamente", HttpStatus.OK);
    }
}