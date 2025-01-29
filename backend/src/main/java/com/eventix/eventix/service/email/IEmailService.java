package com.eventix.eventix.service.email;

import com.eventix.eventix.model.dto.EventReqDto;
import com.eventix.eventix.model.dto.UserDTO;
import jakarta.mail.MessagingException;

public interface IEmailService {
    public void sendEmail(EventReqDto event, UserDTO user) throws MessagingException;
}