package edu.escuelaing.ieti.service;

import edu.escuelaing.ieti.model.Board;
import edu.escuelaing.ieti.model.BoardList;
import edu.escuelaing.ieti.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BoardService {

    Board getBoardById(UUID id);

    List<Board> getAllBoards();

    Board createBoard(Board board);

    Board addList(UUID id, BoardList list);

    List<BoardList> getLists(UUID id);

    BoardList getListByName(UUID id, String name) throws Exception;

    Card addCardToList(UUID id, String name, Card card) throws Exception;

    List<Card> getCards(UUID id, String name) throws Exception;

    Card getCardByName(UUID id, String name, String cardName);
}
