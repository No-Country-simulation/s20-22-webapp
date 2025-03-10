package com.eventix.eventix.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralErrorResponse {
    private LocalDateTime dateTime;
    private String message;
    private String path;
}