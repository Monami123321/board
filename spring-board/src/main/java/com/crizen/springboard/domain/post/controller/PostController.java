package com.crizen.springboard.domain.post.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    public String showPostsPage() {
        // 전체 게시글 보기
        return "posts";
    }

    @GetMapping
    public String showPostsDetailPage() {
        // 글 상세보기
        return "postDetails";
    }

    @GetMapping("/new")
    public String showNewPostPage() {
        // 새 글 작성 폼 보여주기 - 로그인 유저만
        return "newPost";
    }

    @PostMapping
    public String addNewPost() {
        // 새 글 작성 처리
        return "newPost";
    }

    @PostMapping("/{id}/edit")
    public String editPost() {
        // 글 수정 - 작성자만
        return "editPost";
    }

    @PostMapping("/{id}/delete")
    public String deletePost() {
        // 글 삭제 - 작성자, 관리자
        return "deletePost";
    }

}
