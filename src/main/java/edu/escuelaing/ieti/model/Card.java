package edu.escuelaing.ieti.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Card {

    private ArrayList<Label> labels = new ArrayList<Label>();
    private Date creationDate = new Date();
    private Member member;
    private String name;
    private Date dueDate;
    private String description;
    // TODO checklist


    public Card() {}

    public Card(String name, String description, Date dueDate) {

        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.creationDate = new Date();
    }

    public void addLabel(String name) {

        labels.add(new Label(name));
    }

    public ArrayList<Label> getLabels() {
        return labels;
    }

    public Member getMember() {
        return member;
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

    public void setMember(Member member) {

        this.member = member;
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
                "labels=" + labels +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", description='" + description + '\'' +
                ", member=" + member +
                '}';
    }
}
