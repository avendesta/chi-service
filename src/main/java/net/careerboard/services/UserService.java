package net.careerboard.services;

import lombok.RequiredArgsConstructor;
import net.careerboard.models.User;
import net.careerboard.repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public User addUser(User user){
        return this.userRepo.save(user);
    }
}
