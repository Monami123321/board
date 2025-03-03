package com.crizen.springboard.domain.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteCommentRequestDTO {
    Long postId;
    Long commentId;
}
