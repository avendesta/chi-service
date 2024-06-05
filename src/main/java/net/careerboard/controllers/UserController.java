package net.careerboard.controllers;

import lombok.RequiredArgsConstructor;
import net.careerboard.models.User;
import net.careerboard.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    @Value("${greeting}")
    String greeting;
    private final UserService userService;
    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String home() {
        System.out.println("Hello "+greeting);
        return "{'message': 'Hello world'}";
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        var user = userService.findById(userId);
        if (user.isEmpty()) {
            return new ResponseEntity<String>("User with ID=%d not found!".formatted(userId), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
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
