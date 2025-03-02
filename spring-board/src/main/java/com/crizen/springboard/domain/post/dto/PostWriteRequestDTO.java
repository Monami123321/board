package com.crizen.springboard.domain.post.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostWriteRequestDTO {
    private Long postId;
    private Long userId;
    private String postTitle;
    private String postContent;
}
