package com.crizen.springboard.domain.post.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException() {
        super("게시물이 존재하지 않습니다.");
    }
}
