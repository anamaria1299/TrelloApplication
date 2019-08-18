package edu.escuelaing.ieti.model;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Member {

    private UUID id;
    private String name;

    public Member() {}

    public Member(UUID id, String name) {

        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {

        return id;
    }

    public void setId(UUID id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
