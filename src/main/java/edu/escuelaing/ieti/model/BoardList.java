package edu.escuelaing.ieti.model;

import java.util.ArrayList;

public class BoardList {

    private String name;
    private String description;
    private ArrayList<Card> cards;

    public BoardList() {}

    public BoardList(String name, String description) {

        this.name = name;
        this.description = description;
        this.cards = new ArrayList<Card>();
    }

    public void addCard(Card card) {

        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "BoardList{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cards=" + cards +
                '}';
    }
}
