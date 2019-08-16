package edu.escuelaing.ieti.controller;

import edu.escuelaing.ieti.model.Sprint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SprintController {

    @GetMapping("/sprints")
    public List<Sprint> getSprints() {

        //TODO
        return null;
    }
}
