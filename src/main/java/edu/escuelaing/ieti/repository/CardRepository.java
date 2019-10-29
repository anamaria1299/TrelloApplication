package edu.escuelaing.ieti.repository;

import edu.escuelaing.ieti.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card, String> {

    Card findByName(String name);
}
