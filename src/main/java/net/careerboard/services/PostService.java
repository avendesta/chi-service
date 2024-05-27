package net.careerboard.services;

import lombok.RequiredArgsConstructor;
import net.careerboard.models.Post;
import net.careerboard.repos.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepo postRepo;

    public Post addPost(Post post) {
        return this.postRepo.save(post);
    }

    public List<Post> findAllPosts() {
        return this.postRepo.findAll();
    }

    public List<Post> findPostsByUserId(Long userId){
        return this.postRepo.findByUserUserId(userId);
    }
}
