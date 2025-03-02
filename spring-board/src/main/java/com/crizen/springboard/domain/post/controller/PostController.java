package com.crizen.springboard.domain.post.controller;


import com.crizen.springboard.domain.auth.dto.CustomUser;
import com.crizen.springboard.domain.post.dto.PostDetailResponseDTO;
import com.crizen.springboard.domain.post.dto.PostWriteRequestDTO;
import com.crizen.springboard.domain.post.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostServiceImpl postService;

    @GetMapping
    public String showPostsPage(Model model) {
        model.addAttribute("postList", postService.getAllPosts());
        // 전체 게시글 보기
        return "posts";
    }

    @GetMapping("/{id}")
    public String showPostsDetailPage(@PathVariable Long id, Model model) {
        // 글 상세보기
        PostDetailResponseDTO dto = postService.getPostDetail(id);
        model.addAttribute("postDetail", dto);
        System.out.println(dto.toString());
        return "post-detail";
    }

    @GetMapping("/new")
    @PreAuthorize("hasRole('USER')")
    public String showNewPostPage() {
        // 새 글 작성 폼 보여주기 - 로그인 유저만
        return "new-post-form";
    }

    @PostMapping("/new")
    @ResponseBody
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> addNewPost(@AuthenticationPrincipal CustomUser user, @RequestBody PostWriteRequestDTO postWriteRequestDTO) {
        // 새 글 작성 처리, 스프링 시큐리티 컨텍스트 홀더에서 로그인 유저 정보 가져오기 @AuthenticationPrincipal
        postWriteRequestDTO.setUserId(user.getUserId());
        postService.addPost(postWriteRequestDTO);

        return ResponseEntity.ok("글 작성 성공!");
    }

    @PostMapping("/{id}/edit")
    @PreAuthorize("hasRole('USER')")
    public String showEditPost(@AuthenticationPrincipal CustomUser user, @PathVariable Long id) {
        // 글 수정 - 작성자만
        return "redirect:/posts";
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public String doEditPost(@AuthenticationPrincipal CustomUser user, @PathVariable Long id) {
        // 글 수정 - 작성자만
        postService.doEdit(user, id);
        return "redirect:/posts";
    }


    @PostMapping("/{id}/delete")
    @ResponseBody
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deletePost(@AuthenticationPrincipal CustomUser user, @PathVariable("id") Long postId) {
        // 글 삭제 - 작성자, 관리자
        postService.deletePost(user, postId);
        return ResponseEntity.ok("삭제 성공!");
    }

}
