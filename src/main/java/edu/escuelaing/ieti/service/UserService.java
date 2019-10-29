package edu.escuelaing.ieti.service;

import edu.escuelaing.ieti.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getUserByEmail(String email) throws Exception;

    User createUser(User user);
}
