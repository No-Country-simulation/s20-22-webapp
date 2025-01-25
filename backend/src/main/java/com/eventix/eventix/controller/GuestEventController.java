package com.eventix.eventix.controller;

import com.eventix.eventix.model.dto.GuestEventDto;
import com.eventix.eventix.service.guestEvent.IGuestEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/guest-event")
public class GuestEventController {
    private final IGuestEventService guestEventService;

    public GuestEventController(IGuestEventService guestEventService) {
        this.guestEventService = guestEventService;
    }

    @GetMapping
    public ResponseEntity<GuestEventDto> inviteGuest(Long userId, Long eventId){
        return ResponseEntity.ok(this.guestEventService.inviteGuest(userId, eventId));
    }
}
