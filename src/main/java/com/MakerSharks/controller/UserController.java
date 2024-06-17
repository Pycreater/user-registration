package com.MakerSharks.controller;

import com.MakerSharks.model.User;
import com.MakerSharks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @RestController = @Controller + @ResponseBody
 * @Controller = Indicates that the class is a spring MVC controller.
 * @ResponseBody = Indicates that the return value of the methods should be
 * written directly to the HTTP response body(JSON or XML) instead of rendering view.
 */


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Endpoint to register a new user.
     *
     * @param user the user to register
     * @return ResponseEntity with the registered user or the error message
     */

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.resgisterUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error registering user: " + e.getMessage());
        }
    }

    /**
     * Endpoint to fetch a user by their username.
     *
     * @param username the username to search for
     * @return ResponseEntity with the user or the error message.
     */
    @GetMapping("/fetch")
    public ResponseEntity<?> fetchUser(@RequestParam String username) {
        Optional<User> user = userService.fetchUserByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
}
