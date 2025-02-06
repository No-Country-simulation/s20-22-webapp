package com.eventix.eventix.controller;

import com.eventix.eventix.domain.Event;
import com.eventix.eventix.model.dto.EventReqDto;
import com.eventix.eventix.model.dto.EventResDto;
import com.eventix.eventix.service.event.IEventService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventController {
    private final IEventService eventService;

    @GetMapping("/{id}")
    public ResponseEntity<EventResDto> findById(@PathVariable @Min(1) long id){
        Event event = eventService.findById(id);
        return ResponseEntity.ok(eventService.convertToDto(event));
    }

    @PostMapping
    public ResponseEntity<EventResDto> create(@Valid @RequestBody EventReqDto eventReqDto){
        Event event = eventService.create(eventReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.convertToDto(event));
    }

    @PatchMapping
    public ResponseEntity<EventResDto> update(@RequestParam @Min(1) long id, @Valid @RequestBody EventReqDto eventReqDto){
        Event event = eventService.update(id, eventReqDto);
        return ResponseEntity.ok(eventService.convertToDto(event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) long id){
        eventService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
