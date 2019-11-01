package edu.escuelaing.ieti.controller;

import edu.escuelaing.ieti.model.User;
import edu.escuelaing.ieti.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/users")
@Service
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<?> getAllUsers() {

        try {

            return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {

        try {

            return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.ACCEPTED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody User user) {

        try {

            return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login ) throws Exception {

        String jwtToken = "";

        if ( login.getEmail() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String username = login.getEmail();
        String password = login.getPassword();

        //TODO implement logic to verify user credentials
        User user = userService.getUserByEmail(login.getEmail());

        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }
        //
        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
                SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    public class Token
    {

        String accessToken;

        public Token( String accessToken )
        {
            this.accessToken = accessToken;
        }

        public String getAccessToken()
        {
            return accessToken;
        }

        public void setAccessToken( String access_token )
        {
            this.accessToken = access_token;
        }
    }


}
