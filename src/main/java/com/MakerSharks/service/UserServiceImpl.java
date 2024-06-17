package com.MakerSharks.service;

import com.MakerSharks.model.User;
import com.MakerSharks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User resgisterUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> fetchUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
