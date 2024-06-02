package net.careerboard.repos;

import net.careerboard.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepoTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    public void testSaveAndFindById() {
        User user = new User();
        user.setFirstName("John");
        user.setUsername("john.doe");
        user.setLastName("Doe");

        // Save the user
        User savedUser = userRepo.save(user);

        // Find the user by ID
        Optional<User> foundUser = userRepo.findById(savedUser.getUserId());

        // Verify the user details
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUsername()).isEqualTo("john.doe");
        assertThat(foundUser.get().getFirstName()).isEqualTo("John");
        assertThat(foundUser.get().getLastName()).isEqualTo("Doe");
    }
}