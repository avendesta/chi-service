package net.careerboard.services;

import net.careerboard.models.Post;
import net.careerboard.repos.PostRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PostServiceTest {
    @Mock
    private PostRepo postRepo;

    @InjectMocks
    private PostService postService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addPost() {
        Post post = new Post();
        when(postRepo.save(any(Post.class))).thenReturn(post);

        Post createdPost = postService.addPost(post);

        assertEquals(post, createdPost);
        verify(postRepo, times(1)).save(post);
    }

    @Test
    void findAllPosts() {
        List<Post> posts = Arrays.asList(new Post(), new Post());
        when(postRepo.findAll()).thenReturn(posts);

        List<Post> foundPosts = postService.findAllPosts();

        assertEquals(posts, foundPosts);
        verify(postRepo, times(1)).findAll();
    }

    @Test
    void findPostsByUserId() {
        Long userId = 1L;
        List<Post> posts = Arrays.asList(new Post(), new Post());
        when(postRepo.findByUserUserId(userId)).thenReturn(posts);

        List<Post> foundPosts = postService.findPostsByUserId(userId);

        assertEquals(posts, foundPosts);
        verify(postRepo, times(1)).findByUserUserId(userId);
    }

    @Test
    void findById() {
        Long postId = 1L;
        Post post = new Post();
        when(postRepo.findById(postId)).thenReturn(Optional.of(post));

        Optional<Post> foundPost = postService.findById(postId);

        assertTrue(foundPost.isPresent());
        assertEquals(post, foundPost.get());
        verify(postRepo, times(1)).findById(postId);
    }
}