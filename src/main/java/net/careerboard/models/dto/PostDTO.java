package net.careerboard.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.careerboard.models.Post;

@Getter
@Setter
@AllArgsConstructor
public class PostDTO {
    private Long userId;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "CreatePostRequest{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
