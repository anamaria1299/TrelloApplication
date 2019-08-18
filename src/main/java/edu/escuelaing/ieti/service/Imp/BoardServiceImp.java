package edu.escuelaing.ieti.service.Imp;

import edu.escuelaing.ieti.model.Board;
import edu.escuelaing.ieti.model.BoardList;
import edu.escuelaing.ieti.model.Card;
import edu.escuelaing.ieti.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BoardServiceImp implements BoardService {


    @Autowired
    Board board;

    private HashMap<UUID, Board> boards = new HashMap<>();

    @Override
    public Board getBoardById(UUID id) {

        return boards.get(id);
    }

    @Override
    public List<Board> getAllBoards() {

        List<Board> boardList = new ArrayList<>();
        Set<UUID> keys = boards.keySet();

        for(UUID id: keys) {

            boardList.add(boards.get(id));
        }

        return boardList;
    }

    @Override
    public Board createBoard(Board board) {

        // TODO validate uuid or generate it
        boards.put(board.getId(), board);
        return board;
    }

    @Override
    public Board addList(UUID id, BoardList list) {

        Board board = boards.get(id);
        board.addList(list);
        return board;
    }

    @Override
    public List<BoardList> getLists(UUID id) {

        return boards.get(id).getLists();
    }

    @Override
    public BoardList getListByName(UUID id, String name) {
        return null;
    }

    @Override
    public BoardList addCardToList(UUID id, String name, Card card) {
        return null;
    }

    @Override
    public List<Card> getCards(UUID id, String name) {
        return null;
    }

    @Override
    public Card getCardByName(UUID id, String name, String cardName) {
        return null;
    }
}
