package com.eventix.eventix.service;

import com.eventix.eventix.domain.Event;

public interface IEventService {
    Event findEventById(long id);
}
