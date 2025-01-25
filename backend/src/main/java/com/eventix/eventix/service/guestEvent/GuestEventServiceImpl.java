package com.eventix.eventix.service.guestEvent;

import com.eventix.eventix.domain.Event;
import com.eventix.eventix.domain.GuestEvent;
import com.eventix.eventix.domain.User;
import com.eventix.eventix.model.dto.GuestEventDto;
import com.eventix.eventix.repository.IGuestEventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GuestEventServiceImpl implements IGuestEventService {
    private final IGuestEventRepository guestEventRepository;

    private final ModelMapper mapper;

    public GuestEventServiceImpl(IGuestEventRepository guestEventRepository, ModelMapper mapper) {
        this.guestEventRepository = guestEventRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public GuestEventDto inviteGuest(Long userId, Long eventId) {
        User userGuest = new User(); // Validar el guest llamando al service de user que devuelva un user.
        Event event = new Event(); // Validar el event llamando al service de event que devuelva un event.

        GuestEvent guestEvent = new GuestEvent(userGuest, event);

        //Antes de guardar se podria validar la existencia del invitado el evento.

        return mapper.map(this.guestEventRepository.save(guestEvent), GuestEventDto.class);
    }

    @Override
    public GuestEvent uninviteGuest(Long userId, Long eventId) {
        return null;
    }
}
