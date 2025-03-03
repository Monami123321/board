package com.crizen.springboard.domain.comment.service;

import com.crizen.springboard.domain.auth.dto.CustomUser;
import com.crizen.springboard.domain.comment.dto.AddCommentRequestDTO;
import com.crizen.springboard.domain.comment.dto.Comment;
import com.crizen.springboard.domain.comment.dto.DeleteCommentRequestDTO;
import com.crizen.springboard.domain.comment.dto.ShowCommentDTO;
import com.crizen.springboard.domain.comment.mapper.CommentMapper;
import com.crizen.springboard.global.security.AuthChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;
    private final AuthChecker authChecker;


    @Override
    public boolean addComment(CustomUser user, AddCommentRequestDTO addCommentRequestDTO) {
        addCommentRequestDTO.setUserId(user.getUserId());
        return commentMapper.insertComment(addCommentRequestDTO);
    }

    @Override
    public List<ShowCommentDTO> getAllCommentByPostId(Long postId) {
        return commentMapper.findAllWithNameByPostId(postId);
    }

    @Override
    public boolean deleteCommentByid(CustomUser user, DeleteCommentRequestDTO dto) {
        // 관리자면 무조건 삭제
        if (authChecker.isAdmin(user)) {
            return commentMapper.deleteComment(dto.getCommentId());
        }
        // 해당 댓글 작성자면 삭제
        Comment comment = commentMapper.findOneById(dto.getCommentId());
        if (comment == null) {
            return false; // 나중에 exception 만들어두기 CommentNotFoundException
        }
        // 같은 글에서 요청한 게 아닐 때 거부
        if (comment.getPostId() != dto.getPostId().longValue()) {
            return false; // CommentNotBelongToPostException
        }
        // 댓글 작성자가 아니면 거부
        if (comment.getUserId().longValue() != user.getUserId()) {
            return false; // CommentNotBelongToUserException
        }

        // 정당한 요청이면 처리
        return commentMapper.deleteComment(dto.getCommentId());
    }
}
