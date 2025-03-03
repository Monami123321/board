package com.crizen.springboard.domain.comment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ShowCommentDTO {
    private String userName;
    private Long commentId;
    private String commentContent;
    private LocalDateTime commentDate;
}
