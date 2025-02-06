package com.eventix.eventix.service.guestEvent;

import com.eventix.eventix.domain.GuestEvent;
import com.eventix.eventix.model.dto.GuestEventDto;

public interface IGuestEventService {
    GuestEvent inviteGuest(Long userId, Long eventId);
    void uninviteGuest(Long userId, Long eventId);
    GuestEventDto convertToDto(GuestEvent guestEvent);
    GuestEvent convertToEntity(GuestEventDto guestEventDto);
}
