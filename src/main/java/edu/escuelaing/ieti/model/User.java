package edu.escuelaing.ieti.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class User {

    @Id
    private UUID id;
    private String name;
    private String password;
    private String email;

    public User() {}

    public User(UUID id, String name, String password, String email) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "User {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
