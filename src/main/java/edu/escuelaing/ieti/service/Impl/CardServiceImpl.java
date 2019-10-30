package edu.escuelaing.ieti.service.Impl;

import edu.escuelaing.ieti.model.Card;
import edu.escuelaing.ieti.model.User;
import edu.escuelaing.ieti.repository.CardRepository;
import edu.escuelaing.ieti.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {

        return cardRepository.findAll();
    }

    @Override
    public Optional<Card> getCardById(UUID id) {

        return cardRepository.findById(id);
    }

    @Override
    public List<Card> getCardsByResponsible(String email) {

        return cardRepository.findByUser_Email(email);
    }

    @Override
    public Card createCard(Card card) {

        card.setId(UUID.randomUUID());
        cardRepository.save(card);
        return card;
    }

    @Override
    public Card setResponsible(User responsible) {

        return null;
    }

    @Override
    public Card getCardByDate(Date initialDate, Date endDate) {

        return null;
    }

    @Override
    public Card updateCard(Card card) {
        return null;
    }
}
