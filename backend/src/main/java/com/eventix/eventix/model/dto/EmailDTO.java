package com.eventix.eventix.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDTO {
    private String to;
    private String subject;
    private String message;
}