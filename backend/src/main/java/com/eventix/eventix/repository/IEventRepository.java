package com.eventix.eventix.repository;

import com.eventix.eventix.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepository extends JpaRepository<Event, Long> {
}
