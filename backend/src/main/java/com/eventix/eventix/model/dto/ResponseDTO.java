package com.eventix.eventix.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private String message;
    private String jwt;
    private boolean success;
}