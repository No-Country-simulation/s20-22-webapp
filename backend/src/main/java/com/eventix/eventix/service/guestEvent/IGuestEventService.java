package com.eventix.eventix.service.guestEvent;

import com.eventix.eventix.domain.GuestEvent;
import com.eventix.eventix.model.dto.GuestEventDto;

public interface IGuestEventService {
    GuestEventDto inviteGuest(Long userId, Long eventId);
    GuestEvent uninviteGuest(Long userId, Long eventId);

}
