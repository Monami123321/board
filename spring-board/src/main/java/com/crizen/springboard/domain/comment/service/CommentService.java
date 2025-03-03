package com.crizen.springboard.domain.comment.service;

import com.crizen.springboard.domain.auth.dto.CustomUser;
import com.crizen.springboard.domain.comment.dto.AddCommentRequestDTO;
import com.crizen.springboard.domain.comment.dto.Comment;
import com.crizen.springboard.domain.comment.dto.DeleteCommentRequestDTO;
import com.crizen.springboard.domain.comment.dto.ShowCommentDTO;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface CommentService {

    boolean addComment(CustomUser user, AddCommentRequestDTO addCommentRequestDTO);

    List<ShowCommentDTO> getAllCommentByPostId(Long postId);

    boolean deleteCommentByid(CustomUser user, DeleteCommentRequestDTO deleteCommentRequestDTOdto);




}
