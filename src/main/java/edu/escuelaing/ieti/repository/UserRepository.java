package edu.escuelaing.ieti.repository;

import edu.escuelaing.ieti.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    List<User> findById(UUID id);

}
