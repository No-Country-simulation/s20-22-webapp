package com.eventix.eventix.model.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventReqDto {
//    private UserDTO organizer;

    @Min(1)
    private Long organizerId;

    @NotBlank
    @Size(min = 1, max = 150)
    private String title;

    @NotBlank
    @Size(min = 1, max = 250)
    private String description;

    @FutureOrPresent
    private LocalDate startDate;

    @NotBlank
    @Size(min = 1, max = 150)
    private String location;

    @Min(1)
    private Integer max_capacity;
//    private String status;
//    private LocalDate created_at;
//    private LocalDate updated_at;
    @NotBlank
    @Size(min = 1, max = 250)
    private String invitationMessage;
}
