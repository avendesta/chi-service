package net.careerboard.repos;

import net.careerboard.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByUserUserId(Long userId);
}
