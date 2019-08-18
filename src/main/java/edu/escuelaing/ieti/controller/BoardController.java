package edu.escuelaing.ieti.controller;

import edu.escuelaing.ieti.model.Board;
import edu.escuelaing.ieti.model.BoardList;
import edu.escuelaing.ieti.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/boards")
@Service
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping()
    public ResponseEntity<?> getBoards() {

        try {

            return new ResponseEntity<>(boardService.getAllBoards(), HttpStatus.ACCEPTED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public  ResponseEntity<?> getBoardById(@PathVariable String id) {

        try {

            UUID uuid = UUID.fromString(id);
            return new ResponseEntity<>(boardService.getBoardById(uuid), HttpStatus.ACCEPTED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createBoard(@RequestBody Board board) {

        try {

            return new ResponseEntity<>(boardService.createBoard(board), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("{id}/lists")
    public ResponseEntity<?> getLists(@PathVariable String id) {

        UUID uuid = UUID.fromString(id);
        try {

            return new ResponseEntity<>(boardService.getLists(uuid), HttpStatus.ACCEPTED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("{id}/lists")
    public ResponseEntity<?> addListToBoard(@PathVariable String id, @RequestBody BoardList list) {

        UUID uuid = UUID.fromString(id);
        try {

            return new ResponseEntity<>(boardService.addList(uuid, list), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
