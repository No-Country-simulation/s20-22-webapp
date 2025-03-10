package com.eventix.eventix.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventResDto {
    private Long id;
    private UserDTO organizer;
    private String title;
    private String description;
    private LocalDate startDate;
    private String location;
    private Integer max_capacity;
    private String status;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String invitationMessage;
}
