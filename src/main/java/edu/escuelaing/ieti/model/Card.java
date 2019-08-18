package edu.escuelaing.ieti.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Card {

    private ArrayList<Label> labels;
    private String name;
    private Date creationDate;
    private Date dueDate;
    private String description;
    private List<Member> members;
    // TODO checklist


    public Card(String name, String description, Date dueDate) {

        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.creationDate = new Date();
        this.members = new ArrayList<Member>();
        this.labels = new ArrayList<Label>();
    }

    public void addLabel(String name) {

        labels.add(new Label(name));
    }

    public void addMember(Member member) {

        members.add(member);
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
                ", members=" + members +
                '}';
    }
}
