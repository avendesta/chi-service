package net.careerboard.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostRequest {
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
