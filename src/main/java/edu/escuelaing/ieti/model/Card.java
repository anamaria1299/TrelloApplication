package edu.escuelaing.ieti.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class Card {

    private Date creationDate = new Date();
    private User user;
    private String name;
    private Date dueDate;
    private String description;

    public Card() {}

    public Card(String name, String description, Date dueDate, User user) {

        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.creationDate = new Date();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
