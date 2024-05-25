package net.careerboard.services;

import lombok.RequiredArgsConstructor;
import net.careerboard.models.User;
import net.careerboard.repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public void addUser(User user){
        this.userRepo.save(user);
    }
}
