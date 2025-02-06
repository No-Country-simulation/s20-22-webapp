package com.eventix.eventix.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ORGANIZER("ORGANIZADOR"),
    GUEST("INVITADO");

    private final String roleSpanish;

    public String getSpanishRole() {
        return roleSpanish;
    }
}