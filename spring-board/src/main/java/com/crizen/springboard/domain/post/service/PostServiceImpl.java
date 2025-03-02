package com.crizen.springboard.domain.post.service;

import com.crizen.springboard.domain.auth.dto.CustomUser;
import com.crizen.springboard.domain.comment.dto.ShowCommentDTO;
import com.crizen.springboard.domain.comment.service.CommentServiceImpl;
import com.crizen.springboard.domain.post.dto.Post;
import com.crizen.springboard.domain.post.dto.PostDetailResponseDTO;
import com.crizen.springboard.domain.post.dto.PostListResponseDTO;
import com.crizen.springboard.domain.post.dto.PostWriteRequestDTO;
import com.crizen.springboard.domain.post.mapper.PostMapper;
import com.crizen.springboard.global.security.AuthChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostMapper postMapper;
    private final CommentServiceImpl commentService;
    private final AuthChecker authChecker;

    @Override
    public String getUserNameOnPost(Long postId) {
        return postMapper.findUserNameByPostId(postId);
    }

    @Override

    public List<PostListResponseDTO> getAllPosts() {
        return postMapper.findAll();
    }

    @Override
    public PostDetailResponseDTO getPostDetail(Long postId) {
        // 게시물 상세 + 댓글 함께 리턴

        Post post = postMapper.findOneByPostId(postId);
        List<ShowCommentDTO> commentList = commentService.getAllCommentByPostId(postId);
        PostDetailResponseDTO dto = new PostDetailResponseDTO();
        dto.setUsername(getUserNameOnPost(postId));
        dto.setCommentList(commentList);
        dto.setPost(post);
        return dto;
    }

    @Override
    public boolean addPost(PostWriteRequestDTO postWriteRequestDTO) {
        return postMapper.insertPost(postWriteRequestDTO);
    }

    @Override
    public boolean editPost(PostWriteRequestDTO postWriteRequestDTO) {
        return false;
    }

    @Override
    public boolean deletePost(CustomUser user, Long postId) {
        // 관리자면 그냥 무조건 삭제
        if (authChecker.isAdmin(user)) {
            postMapper.deletePost(postId);
            return true;
        }

        // 글 작성자면 삭제
        if (validateWriter(user, postId)) {
            postMapper.deletePost(postId);
            return true;
        }
        return false;
    }


    @Override
    public boolean validateWriter(CustomUser user, Long postId) {
        // 로그인 유저의 id 와 게시글 userId가 같으면 동일인 ok
        Long userId = postMapper.findUserIdByPostId(postId);
        return user.getUserId().longValue() == userId;
    }

    @Override
    public boolean doEdit(CustomUser user, Long postId) {
        if (!validateWriter(user, postId)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean doDelete(CustomUser user, Long postId) {
        return false;
    }
}
