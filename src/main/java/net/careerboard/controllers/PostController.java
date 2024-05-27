package net.careerboard.controllers;

import lombok.RequiredArgsConstructor;
import net.careerboard.models.Post;
import net.careerboard.models.User;
import net.careerboard.models.dto.CreatePostRequest;
import net.careerboard.models.dto.PostDTO;
import net.careerboard.services.PostService;
import net.careerboard.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final UserService userService;
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody CreatePostRequest request) {
        Optional<User> userOptional = userService.findById(request.getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Post post = new Post();
            post.setUser(user);
            post.setTitle(request.getTitle());
            post.setContent(request.getContent());
            post.setCreatedAt(LocalDateTime.now());

            Post savedPost = postService.addPost(post);
            return ResponseEntity.ok(savedPost.getPostDTO());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
