package edu.escuelaing.ieti.repository;

import edu.escuelaing.ieti.model.BoardList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardListRepository extends MongoRepository<BoardList, String> {

    BoardList findByName(String name);
}
