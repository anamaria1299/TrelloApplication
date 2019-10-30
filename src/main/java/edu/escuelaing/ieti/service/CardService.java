package edu.escuelaing.ieti.service;

import edu.escuelaing.ieti.model.Card;
import edu.escuelaing.ieti.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CardService {

    List<Card> getAllCards();

    Optional<Card> getCardById(UUID id);

    List<Card> getCardsByResponsible(String email);

    Card createCard(Card card);

    Card setResponsible(User responsible);

    Card getCardByDate(Date initialDate, Date endDate);

    Card updateCard(Card card);
}
