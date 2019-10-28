package edu.escuelaing.ieti.service.Imp;

import edu.escuelaing.ieti.model.User;
import edu.escuelaing.ieti.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserServiceImp implements UserService {

    @Autowired
    User user;

    private HashMap<UUID, User> users = new HashMap<>();

    public UserServiceImp() {

        User user = new User(UUID.randomUUID(),"Ana Rincon", "ana123", "anamaria@mail.com");
        User user1 = new User(UUID.randomUUID(),"Andres Rodriguez", "andres123", "andres@mail.com");
        users.put(user.getId(), user);
        users.put(user1.getId(), user1);
    }

    @Override
    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();
        Set<UUID> keys = users.keySet();

        for(UUID id: keys) {

            userList.add(users.get(id));
        }

        return userList;
    }

    @Override
    public User getUserById(UUID id) {

        return users.get(id);
    }

    @Override
    public User getUserByEmail(String email) throws Exception {

        List<User> userList = getAllUsers();

        for(User m: userList) {
            if(m.getEmail().equals(email)) return m;
        }

        throw new Exception("User with email [ "+ email + " ] does not exist");
    }

    @Override
    public User createUser(User user) {

        // TODO validate UUID or generate it
        users.put(user.getId(), user);
        return user;
    }
}
