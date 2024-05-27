package net.careerboard.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.careerboard.models.dto.PostDTO;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "user_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @JsonIgnoreProperties("post")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Post{" +
                "user=" + user +
                ", title='" + title + '\'' +
                '}';
    }

    public PostDTO getPostDTO(){
        return new PostDTO(getUser().getUserId(), getTitle(), getContent());
    }
}
