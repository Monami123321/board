package com.crizen.springboard.domain.post.exception;

public class PostNotBelongToUserException extends RuntimeException {
    public PostNotBelongToUserException() {
        super("게시물 작성자가 아닙니다.");

    }
}
