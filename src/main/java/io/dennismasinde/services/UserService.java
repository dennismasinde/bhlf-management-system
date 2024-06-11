package io.dennismasinde.services;

import io.dennismasinde.entities.User;
import io.dennismasinde.exceptions.EntityNotFoundException;
import io.dennismasinde.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + userId));
    }
}
