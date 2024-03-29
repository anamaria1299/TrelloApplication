package edu.escuelaing.ieti.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class Card {

    @Id
    private UUID id;
    private Date creationDate = new Date();
    private User user;
    private String name;
    private Date dueDate;
    private String description;
    private int priority;
    private String state;

    public Card() {}

    public Card(String name, String description, Date dueDate, User user, UUID id, String state) {

        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.creationDate = new Date();
        this.user = user;
        this.id = id;
        this.state = state;
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

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Card{" +
                "creationDate=" + creationDate +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", dueDate=" + dueDate +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", priority=" + priority +
                '}';
    }
}
