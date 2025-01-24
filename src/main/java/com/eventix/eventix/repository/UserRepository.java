package com.eventix.eventix.repository;

import com.eventix.eventix.domain.User;
import com.eventix.eventix.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    List<User> findByRole(Role role);
    List<User> findByFirstNameAndLastName(String firstName, String lastName);

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    Optional<User> findByEmail(String email);
}