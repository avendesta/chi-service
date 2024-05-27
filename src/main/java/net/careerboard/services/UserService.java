package net.careerboard.services;

import lombok.RequiredArgsConstructor;
import net.careerboard.models.User;
import net.careerboard.repos.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public User addUser(User user){
        return this.userRepo.save(user);
    }

    public Optional<User> findById(Long userId) {
        return userRepo.findById(userId);
    }
}
