package com.eventix.eventix.service.guestEvent;

import com.eventix.eventix.domain.Event;
import com.eventix.eventix.domain.GuestEvent;
import com.eventix.eventix.domain.GuestEventPK;
import com.eventix.eventix.domain.User;
import com.eventix.eventix.model.dto.EventResDto;
import com.eventix.eventix.model.dto.GuestEventDto;
import com.eventix.eventix.model.dto.UserDTO;
import com.eventix.eventix.repository.IGuestEventRepository;
import com.eventix.eventix.service.event.IEventService;
import com.eventix.eventix.service.user.IUserService;
import com.eventix.eventix.shared.exception.personalized.RegistryAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GuestEventServiceImpl implements IGuestEventService {
    private final IGuestEventRepository guestEventRepository;
    private final IUserService userService;
    private final IEventService eventService;
    private final ModelMapper mapper;


    @Override
    @Transactional
    public GuestEvent inviteGuest(Long userId, Long eventId) {
        User userGuest = mapper.map(userService.getUserById(userId), User.class );
        Event event = eventService.findById(eventId);

        if (!guestExistsInEvent(userGuest, event)) {
            throw new RegistryAlreadyExistsException(
                    String.format("UserId: %d - EventId: %d", userGuest.getUserId(), event.getId())
            );
        }

        GuestEvent guestEvent = new GuestEvent(userGuest, event);

        return this.guestEventRepository.save(guestEvent);
    }

    private boolean guestExistsInEvent(User user, Event event){
        GuestEventPK guestEventPK = new GuestEventPK(user, event);
        return this.guestEventRepository.existsById(guestEventPK);
    }

    @Override
    public void uninviteGuest(Long userId, Long eventId) {
        User userGuest = mapper.map(userService.getUserById(userId), User.class );
        Event event = eventService.findById(eventId);

        if (!guestExistsInEvent(userGuest, event)) {
            throw new RegistryAlreadyExistsException(
                    String.format("UserId: %d - EventId: %d", userGuest.getUserId(), event.getId())
            );
        }

        GuestEvent guestEvent = new GuestEvent(userGuest, event);

        this.guestEventRepository.delete(guestEvent);
    }

    @Override
    public GuestEventDto convertToDto(GuestEvent guestEvent) {
        UserDTO userDTO = mapper.map(guestEvent.getUser(), UserDTO.class);
        EventResDto eventDto = mapper.map(guestEvent.getEvent(), EventResDto.class);

        return new GuestEventDto(userDTO, eventDto);
    }

    @Override
    public GuestEvent convertToEntity(GuestEventDto guestEventDto) {
        User user = mapper.map(guestEventDto.getUser(), User.class);
        Event event = mapper.map(guestEventDto.getEvent(), Event.class);

        return new GuestEvent(user, event);
    }
}
