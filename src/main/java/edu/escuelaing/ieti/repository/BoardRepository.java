package edu.escuelaing.ieti.repository;

import edu.escuelaing.ieti.model.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface BoardRepository extends MongoRepository<Board, UUID> {

    Optional<Board> findById(UUID id);

}
