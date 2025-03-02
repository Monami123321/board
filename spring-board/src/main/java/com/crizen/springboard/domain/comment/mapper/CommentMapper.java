package com.crizen.springboard.domain.comment.mapper;

import com.crizen.springboard.domain.comment.dto.AddCommentRequestDTO;
import com.crizen.springboard.domain.comment.dto.Comment;
import com.crizen.springboard.domain.comment.dto.ShowCommentDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    // 게시글에 속하는 모든 댓글 작성자 이름 함께
    @Select("select comment_content, comment_date, user_name\n" +
            "from comments c inner join posts p on p.post_id = c.post_id\n" +
            "inner join users u on p.user_id = u.user_id\n" +
            "where p.post_id = #{postId}")
    List<ShowCommentDTO> findAllWithNameByPostId(@Param("postId") Long postId);


    // 댓글 쓰기
    @Insert("INSERT INTO comments(post_id, user_id, comment_content) VALUES (#{postId}, #{userId}, #{commentContent})")
    boolean insertComment(AddCommentRequestDTO addCommentRequestDTO);

    // 게시글에 속하는 모든 댓글 조회
    @Select("SELECT * from comments WHERE post_id = #{postId}")
    List<Comment> findAllByPostId(@Param("postId") Long postId);

    // 댓글 삭제
    @Delete("DELETE FROM comments WHERE comment_id = #{commentId}")
    boolean deleteComment(@Param("commentId") Long commentId);


}
