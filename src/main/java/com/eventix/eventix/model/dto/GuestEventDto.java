package com.eventix.eventix.model.dto;

import com.eventix.eventix.domain.Event;
import com.eventix.eventix.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class GuestEventDto {
    private User user;
    private Event event;

    public GuestEventDto(Event event, User user) {
        this.event = event;
        this.user = user;
    }
}
