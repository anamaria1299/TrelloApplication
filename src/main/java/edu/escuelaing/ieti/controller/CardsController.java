package edu.escuelaing.ieti.controller;

import edu.escuelaing.ieti.model.Card;
import edu.escuelaing.ieti.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/cards")
@Service
public class CardsController {

    @Autowired
    CardService cardService;

    @GetMapping()
    public ResponseEntity<?> getAllCards() {

        try {
            return new ResponseEntity<>(cardService.getAllCards(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getCardByResponsible(@PathVariable String email) {

        try {

            return new ResponseEntity<>(cardService.getCardsByResponsible(email), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createCard(@RequestBody Card card) {

        try {

            return new ResponseEntity<>(cardService.createCard(card), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}