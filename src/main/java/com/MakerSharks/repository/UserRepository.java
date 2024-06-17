package com.MakerSharks.repository;

import com.MakerSharks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for User entity.
 * Extends JpaRepository to provide CRUD operations.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find a user by their username.
     *
     * @param username the username to search for
     * @return an Optional containing the user if found or empty if not
     */

    Optional<User> findByUsername(String username); //it may or may not return a result(null).
}
