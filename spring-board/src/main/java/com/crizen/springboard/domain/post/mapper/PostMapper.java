package com.crizen.springboard.domain.post.mapper;

import com.crizen.springboard.domain.post.dto.Post;
import com.crizen.springboard.domain.post.dto.PostListResponseDTO;
import com.crizen.springboard.domain.post.dto.PostWriteRequestDTO;
import com.crizen.springboard.domain.user.dto.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    // 작성자 이름 조회
    @Select("SELECT user_name FROM users u INNER JOIN posts p on u.user_id = p.user_id WHERE p.post_id = #{postId}")
    String findUserNameByPostId(@Param("postId") Long postId);

    // 작성자 id 조회
    @Select("SELECT user_id FROM posts WHERE post_id = #{postId}")
    Long findUserIdByPostId(@Param("postId") Long postId);

    // 특정 게시물
    @Select("SELECT * FROM posts WHERE post_id = #{postId}")
    Post findOneByPostId(@Param("postId") Long postId);

    @Select("SELECT post_id, user_name, post_title, post_content, post_date FROM posts p inner join users u on p.user_id = u.user_id order by post_id desc")
    List<PostListResponseDTO> findAll();

    @Insert("INSERT INTO posts (user_id, post_title, post_content) VALUES (#{userId}, #{postTitle}, #{postContent})")
    boolean insertPost(PostWriteRequestDTO postWriteRequestDTO);

    @Update("UPDATE posts SET post_title = #{postTitle}, post_content = #{postContent}, post_date = CURRENT_TIMESTAMP WHERE post_id = #{postId}")
    boolean updatePost(PostWriteRequestDTO postWriteRequestDTO);

    @Delete("DELETE FROM posts where post_id = #{postId}")
    boolean deletePost(@Param("postId") Long postId);

}
