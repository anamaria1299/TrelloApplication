package edu.escuelaing.ieti.repository;

import edu.escuelaing.ieti.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface CardRepository extends MongoRepository<Card, UUID> {

    Optional<Card> findById(UUID id);

    List<Card> findAll();

    List<Card> findByUser_Email(String email);
}
