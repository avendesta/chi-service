package net.careerboard.services;

import lombok.RequiredArgsConstructor;
import net.careerboard.models.Post;
import net.careerboard.models.User;
import net.careerboard.repos.PostRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo postRepo;

    public Post addPost(Post post) {
        return this.postRepo.save(post);
    }
}
