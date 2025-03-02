package com.crizen.springboard.domain.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCommentRequestDTO {
    private Long postId;
    private Long userId;
    private String commentContent;
}
