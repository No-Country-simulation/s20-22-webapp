package com.eventix.eventix.service.event;

import com.eventix.eventix.domain.Event;
import com.eventix.eventix.enums.EventStatus;
import com.eventix.eventix.model.dto.EventReqDto;
import com.eventix.eventix.model.dto.EventResDto;
import com.eventix.eventix.repository.IEventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements IEventService {
    private final IEventRepository eventRepository;
    private final ModelMapper mapper;

    @Override
    public Event findById(long id) {
        Event event = eventRepository.findById(id).orElseThrow(); //TODO: Crear excepciones personalizadas
        return event;
    }

    @Override
    public Event create(EventReqDto eventReqDto) {
        Event event = mapper.map(eventReqDto, Event.class);

        event.setStatus(EventStatus.PENDING);
        event.setCreated_at(LocalDate.now());
        event.setUpdated_at(LocalDate.now());

        return eventRepository.save(event);
    }

    @Override
    public Event update(long id, EventReqDto eventReqDto) {
        Event event = this.findById(id);

        event.setTitle(eventReqDto.getTitle());
        event.setDescription(eventReqDto.getDescription());
        event.setStartDate(eventReqDto.getStartDate());
        event.setLocation(eventReqDto.getLocation());
        event.setMax_capacity(eventReqDto.getMax_capacity());
        event.setStatus(EventStatus.PENDING);   //TODO: Revisar en que casos modificar el estado.
        event.setUpdated_at(LocalDate.now());
        event.setInvitationMessage(eventReqDto.getInvitationMessage());

        return eventRepository.save(event);
    }

    @Override
    public void delete(long id) {
        boolean eventExists = this.existById(id);
        if (eventExists){
            eventRepository.deleteById(id);
        } else {
            throw new NullPointerException(); // TODO: Cambiar por excepcion personalizada
        }
    }

    private boolean existById(long id) {
        return eventRepository.existsById(id);
    }

    @Override
    public EventResDto convertToDto(Event event){
        return mapper.map(event, EventResDto.class); //TODO: Comprobar si el User a UserDTO se convierte automaticamente.
    }

    @Override
    public Event convertToEntity(EventResDto eventDto){
        return mapper.map(eventDto, Event.class); //TODO: Comprobar si el UserDTO a User se convierte automaticamente.
    }
}
