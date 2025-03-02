package com.crizen.springboard.domain.post.service;

import com.crizen.springboard.domain.auth.dto.CustomUser;
import com.crizen.springboard.domain.post.dto.PostDetailResponseDTO;
import com.crizen.springboard.domain.post.dto.PostListResponseDTO;
import com.crizen.springboard.domain.post.dto.PostWriteRequestDTO;

import java.util.List;

public interface PostService {

    // 글 작성자 이름
    String getUserNameOnPost(Long postId);


    // 전체 게시물 조회
    List<PostListResponseDTO> getAllPosts();

    // 특정 게시물 조회
    PostDetailResponseDTO getPostDetail(Long postId);

    // 게시물 작성
    boolean addPost(PostWriteRequestDTO postWriteRequestDTO);

    // 게시물 수정
    boolean editPost(PostWriteRequestDTO postWriteRequestDTO);

    // 게시물 삭제
    boolean deletePost(CustomUser user, Long postId);

    // 글 작성자 - 로그인 유저 검증
    boolean validateWriter(CustomUser user, Long postId);

    // 게시글 수정 요청 처리
    boolean doEdit(CustomUser user, Long postId);

    // 게시글 삭제 요청 처리
    boolean doDelete(CustomUser user, Long postId);

}
