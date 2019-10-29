package edu.escuelaing.ieti.repository;

import edu.escuelaing.ieti.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    @NotNull
    List<User> findAll();
}
