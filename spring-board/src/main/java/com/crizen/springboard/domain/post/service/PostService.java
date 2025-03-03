package com.crizen.springboard.domain.post.service;

import com.crizen.springboard.domain.auth.dto.CustomUser;
import com.crizen.springboard.domain.post.dto.Post;
import com.crizen.springboard.domain.post.dto.PostDetailResponseDTO;
import com.crizen.springboard.domain.post.dto.PostListResponseDTO;
import com.crizen.springboard.domain.post.dto.PostWriteRequestDTO;

import java.util.List;

public interface PostService {

    // 수정을 위한 글 상세조회
    Post getPostDetailForEdit(CustomUser user, Long postId);

    // 수정을 위한 해당 글 권한 조회
    boolean checkEditPermission(CustomUser user, Long postId);

    // 글 작성자 이름
    String getUserNameOnPost(Long postId);

    // 전체 게시물 조회
    List<PostListResponseDTO> getAllPosts();

    // 특정 게시물 조회
    PostDetailResponseDTO getPostDetail(Long postId);

    // 게시물 작성
    boolean addPost(PostWriteRequestDTO postWriteRequestDTO);

    // 게시물 수정
    boolean editPost(CustomUser user, PostWriteRequestDTO postWriteRequestDTO);

    // 게시물 삭제
    boolean deletePost(CustomUser user, Long postId);

    // 작성자 체크
    public boolean validateWriter(CustomUser user, Long postId);
}
