package com.MakerSharks.service;

import com.MakerSharks.model.User;

import java.util.Optional;

/**
 * we can achieve 100% abstraction through interfaces.
 * so that why we are gonna create an interface an use it's Object
 * later in our controller with the help of Autowiring(@Autowired annotation) ->
 * it internally add's dependencies without any external configurations,
 * which makes our code more robust and scalable.
 */

public interface UserService {
    /**
     * Register a new user.
     *
     * It takes
     * @param User as a parameter and
     *             saves in database and return the user.
     * @return registered user
     */
    public User resgisterUser(User user);

    /**
     * Fetch a user by their username.
     *
     * @param username the username to search for
     * @return an Optional containing the user if found, or empty if not
     */

    public Optional<User> fetchUserByUsername(String username);
}
