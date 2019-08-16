package edu.escuelaing.ieti.model;

import java.util.ArrayList;
import java.util.Date;

public class Task {

    private Priority priority;
    private State state;
    private ArrayList<Label> labels;
    private Date creationDate;
    private Date dueDate;
    private String description;
    private Member owner;
}
