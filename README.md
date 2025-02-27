# Spring을 활용한 게시판 프로젝트

* 회원가입 기능
 GET /register → 회원가입 폼 페이지.
 POST /register → 사용자 정보 저장. 

* 로그인 기능 
 GET /login → 로그인 폼.
 POST /login → 사용자 인증 및 세션 생성.
 GET /logout → 세션 종료.

* 게시판 기능
 게시글 목록 보기 (GET /posts).
 게시글 상세 보기 (GET /posts/{id}).
 게시글 작성 (GET /posts/new, POST /posts).
 게시글 수정 및 삭제 (POST /posts/{id}/edit, POST /posts/{id}/delete).

* 댓글 기능
 댓글 작성 (POST /comments/add)
 댓글 삭제 (POST /comments/{id}/delete)



