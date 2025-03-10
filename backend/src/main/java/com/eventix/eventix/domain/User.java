package com.eventix.eventix.domain;

import com.eventix.eventix.enums.Role;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;
    @Column(name = "firstName", length = 60, nullable = false)
    private String firstName;
    @Column(name = "lastName", length = 60, nullable = false)
    private String lastName;
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;
    @Column(name = "password", length = 100, nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "created_at", nullable = true)
    @CreationTimestamp(source = SourceType.DB)
    private Timestamp createdAt;
}