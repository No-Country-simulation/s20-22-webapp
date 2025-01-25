package com.eventix.eventix.domain;

import com.eventix.eventix.enums.EventStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private User organizer;

    @Column(length = 150, nullable = false)
    private String title;

    @Column(length = 250, nullable = false)
    private String description;

    private LocalDate startDate;

    @Column(length = 150, nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer max_capacity;

    private EventStatus status;

    private LocalDate created_at;

    private LocalDate updated_at;

    @Column(length = 250, nullable = false)
    private String invitationMessage;
}
