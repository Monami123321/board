package com.crizen.springboard.domain.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostListResponseDTO {
    private Long postId;
    private String userName;
    private String postTitle;
    private String postContent;
    private LocalDateTime postDate;

}
