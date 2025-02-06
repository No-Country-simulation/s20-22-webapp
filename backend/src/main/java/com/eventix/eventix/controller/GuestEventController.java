package com.eventix.eventix.controller;

import com.eventix.eventix.domain.GuestEvent;
import com.eventix.eventix.model.dto.GuestEventDto;
import com.eventix.eventix.service.guestEvent.IGuestEventService;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/guest-event")
public class GuestEventController {
    private final IGuestEventService guestEventService;

    public GuestEventController(IGuestEventService guestEventService) {
        this.guestEventService = guestEventService;
    }

    @PostMapping("/invite/{user-id}/{event-id}")
    public ResponseEntity<GuestEventDto> inviteGuest(
            @PathVariable(value = "user-id") @Min(1) Long userId,
            @PathVariable(value = "event-id") @Min(1) Long eventId
    ){
        GuestEvent response = this.guestEventService.inviteGuest(userId, eventId);
        return ResponseEntity.ok(guestEventService.convertToDto(response));
    }

    @DeleteMapping("/uninvite/{user-id}/{event-id}")
    public ResponseEntity<Void> uninviteGuest(
            @PathVariable(value = "user-id") @Min(1) Long userId,
            @PathVariable(value = "event-id") @Min(1) Long eventId
    ){
        guestEventService.uninviteGuest(userId, eventId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
