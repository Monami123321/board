package com.crizen.springboard.domain.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Post {
    private Long postId;
    private Long userId;
    private String postTitle;
    private String postContent;
    private LocalDateTime postDate;
}
