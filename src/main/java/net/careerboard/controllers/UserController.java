package net.careerboard.controllers;

import lombok.RequiredArgsConstructor;
import net.careerboard.models.User;
import net.careerboard.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String home() {
        return "{'message': 'Hello world'}";
    }

    @PostMapping(value = "/user")
    public ResponseEntity<String> createUser(@RequestBody User user){
        try{
            User createdUser = this.userService.addUser(user);
            return new ResponseEntity<>("User is created successfully: " + createdUser.toString(), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>("User is creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
