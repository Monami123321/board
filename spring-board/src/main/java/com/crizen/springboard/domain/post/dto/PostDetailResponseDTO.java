package com.crizen.springboard.domain.post.dto;

import com.crizen.springboard.domain.comment.dto.Comment;
import com.crizen.springboard.domain.comment.dto.ShowCommentDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
public class PostDetailResponseDTO {
    private Post post;
    private String username;
    private List<ShowCommentDTO> commentList;
}
