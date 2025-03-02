package com.crizen.springboard.domain.comment.service;

import com.crizen.springboard.domain.comment.dto.AddCommentRequestDTO;
import com.crizen.springboard.domain.comment.dto.Comment;
import com.crizen.springboard.domain.comment.dto.ShowCommentDTO;

import java.util.List;

public interface CommentService {

    boolean addComment(AddCommentRequestDTO addCommentRequestDTO);

    List<ShowCommentDTO> getAllCommentByPostId(Long postId);

    boolean deleteCommentByid(Long commentId);




}
