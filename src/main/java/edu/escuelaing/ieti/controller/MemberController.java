package edu.escuelaing.ieti.controller;

import edu.escuelaing.ieti.model.Member;
import edu.escuelaing.ieti.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.UUID;

@RestController
@RequestMapping(value = "/members")
@Service
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping()
    public ResponseEntity<?> getAllMembers() {

        try {

            return new ResponseEntity<>(memberService.getAllMembers(),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getMemberById(@PathVariable String id) {

        UUID uuid = UUID.fromString(id);

        try {

            return new ResponseEntity<>(memberService.getMemberById(uuid), HttpStatus.ACCEPTED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createMember(@RequestBody Member member) {

        try {

            return new ResponseEntity<>(memberService.createMember(member), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }


}
