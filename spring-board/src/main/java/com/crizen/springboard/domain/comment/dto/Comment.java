package com.crizen.springboard.domain.comment.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class Comment {
    private Long commentId;
    private Long postId;
    private Long userId;
    private String commentContent;
    private LocalDateTime commentDate;
}
