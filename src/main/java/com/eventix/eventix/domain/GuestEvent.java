package com.eventix.eventix.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "guest-event")
@IdClass(GuestEventPK.class)
public class GuestEvent {
    @Id
    private User user;

    @Id
    private Event event;

    public GuestEvent(User user, Event event) {
        this.user = user;
        this.event = event;
    }
}
