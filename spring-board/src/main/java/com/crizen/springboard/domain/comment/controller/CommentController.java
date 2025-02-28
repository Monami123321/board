package com.crizen.springboard.domain.comment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {


    @PostMapping("/add")
    public String addComment() {
        // 댓글 달기, 로그인 유저만
        return "aa";
    }

    @PostMapping("/{id}/delete")
    public String deleteComment(@PathVariable long id) {
        // 댓글 삭제 - 글 작성자, 관리자만 허용
        return "aa";
    }
}
