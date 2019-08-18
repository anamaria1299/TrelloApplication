package edu.escuelaing.ieti.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Board {

    private UUID id;
    private String name;
    private List<BoardList> lists;

    public Board() {}

    public Board(String name, UUID id) {

        this.name= name;
        this.id= id;
        this.lists = new ArrayList<BoardList>();
    }

    public void addList(BoardList list) {

        lists.add(list);
    }

    public UUID getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public List<BoardList> getLists() {
        return lists;
    }

    public void setId(UUID id) {

        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLists(List<BoardList> lists) {
        this.lists = lists;
    }
}