package com.crizen.springboard.domain.comment.controller;


import com.crizen.springboard.domain.auth.dto.CustomUser;
import com.crizen.springboard.domain.comment.dto.AddCommentRequestDTO;
import com.crizen.springboard.domain.comment.dto.DeleteCommentRequestDTO;
import com.crizen.springboard.domain.comment.service.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentServiceImpl commentService;

    @PostMapping("/add")
    @ResponseBody
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> addComment1(@AuthenticationPrincipal CustomUser user, @RequestBody AddCommentRequestDTO dto) {
        // 댓글 달기, 로그인 유저만
        if (commentService.addComment(user, dto)) {
            return ResponseEntity.ok("댓글 달기 성공!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("댓글 달기 실패!");
    }

    @PostMapping("/{id}/delete")
    @ResponseBody
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteComment(@AuthenticationPrincipal CustomUser user, @RequestBody DeleteCommentRequestDTO dto) {
        // 댓글 삭제 - 글 작성자, 관리자만 허용
        if (commentService.deleteCommentByid(user, dto)) {
            return ResponseEntity.ok().body("댓글 삭제 성공!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("댓글 삭제 실패!");
    }
}
