package net.careerboard.controllers;

import lombok.RequiredArgsConstructor;
import net.careerboard.models.User;
import net.careerboard.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String home() {
        return "{'message': 'Hello world'}";
    }

    @PostMapping(value = "/user")
    public User user(){
        User sampleUser = new User(1L,"adesta","aven", "desta", LocalDateTime.now(), true );
        this.userService.addUser(sampleUser);
        return sampleUser;
    }

}
