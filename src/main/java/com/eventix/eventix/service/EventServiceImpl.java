package com.eventix.eventix.service;

import com.eventix.eventix.domain.Event;
import com.eventix.eventix.repository.IEventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements IEventService {
    private final IEventRepository eventRepository;

    private final ModelMapper mapper;

    public EventServiceImpl(IEventRepository eventRepository, ModelMapper mapper) {
        this.eventRepository = eventRepository;
        this.mapper = mapper;
    }

    @Override
    public Event findEventById(long id) {
        return null;
    }
}
