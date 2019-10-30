package edu.escuelaing.ieti.service.Impl;

import edu.escuelaing.ieti.model.User;
import edu.escuelaing.ieti.repository.UserRepository;
import edu.escuelaing.ieti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    User user;

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl() {}

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user) {

        user.setId(UUID.randomUUID());
        userRepository.save(user);
        return user;
    }
}
