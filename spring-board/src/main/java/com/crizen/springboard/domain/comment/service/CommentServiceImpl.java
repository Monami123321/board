package com.crizen.springboard.domain.comment.service;

import com.crizen.springboard.domain.comment.dto.AddCommentRequestDTO;
import com.crizen.springboard.domain.comment.dto.ShowCommentDTO;
import com.crizen.springboard.domain.comment.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;


    @Override
    public boolean addComment(AddCommentRequestDTO addCommentRequestDTO) {
        return commentMapper.insertComment(addCommentRequestDTO);
    }

    @Override
    public List<ShowCommentDTO> getAllCommentByPostId(Long postId) {
        return commentMapper.findAllWithNameByPostId(postId);
    }

    @Override
    public boolean deleteCommentByid(Long commentId) {
        return false;
    }
}
