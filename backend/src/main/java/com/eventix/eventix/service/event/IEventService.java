package com.eventix.eventix.service.event;

import com.eventix.eventix.domain.Event;
import com.eventix.eventix.model.dto.EventReqDto;
import com.eventix.eventix.model.dto.EventResDto;

public interface IEventService {
    Event findById(long id);
    Event create(EventReqDto eventReqDto);
    Event update(long id, EventReqDto eventReqDto);
    void delete(long id);
    EventResDto convertToDto(Event event);
    Event convertToEntity(EventResDto eventDto);
}
