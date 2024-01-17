package com.jatin.popcornTime.services;

import com.jatin.popcornTime.repositories.UserRepository;
import com.jatin.popcornTime.dtos.CreateUserDTO;
import com.jatin.popcornTime.models.User;
import com.jatin.popcornTime.repositories.UserRepository;
import com.jatin.popcornTime.services.password.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(CreateUserDTO userRequest) {

        User user = new User(userRequest.getUsername());
        user.setPassword(userRequest.getPassword(), passwordEncoder);

        return userRepository.save(user);
    }

    public boolean doesUserExist(String username, String email) {

        if (userRepository.findUserByUsername(username).isPresent()) {
            return true;
        }

        if (userRepository.findUserByEmail(email).isPresent()) {
            return true;
        }

        return false;
    }

}
