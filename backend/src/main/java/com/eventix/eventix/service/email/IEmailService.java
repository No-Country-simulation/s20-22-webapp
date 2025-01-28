package com.eventix.eventix.service.email;

import com.eventix.eventix.model.dto.EmailDTO;
import jakarta.mail.MessagingException;

public interface IEmailService {
    public void sendEmail(EmailDTO email) throws MessagingException;
}