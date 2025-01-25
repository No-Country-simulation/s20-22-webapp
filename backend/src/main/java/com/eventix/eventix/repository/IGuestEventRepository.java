package com.eventix.eventix.repository;

import com.eventix.eventix.domain.GuestEvent;
import com.eventix.eventix.domain.GuestEventPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGuestEventRepository extends JpaRepository<GuestEvent, GuestEventPK> {
}
