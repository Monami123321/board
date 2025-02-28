DROP SCHEMA IF EXISTS `board`;
CREATE SCHEMA `board`;
USE `board`;

# 테이블 생성

CREATE TABLE `users` (
	`user_id`	BIGINT	AUTO_INCREMENT,
	`role_id`	BIGINT	NULL,
	`user_name`	VARCHAR(255)	NOT NULL,
	`user_mail`	VARCHAR(255)	NOT NULL	,
	`user_password`	VARCHAR(255)	NOT NULL	,
	`user_join_date`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`user_id`)
);

CREATE TABLE `role` (
	`role_id`	BIGINT	AUTO_INCREMENT,
	`role_name`	VARCHAR(255)	NOT NULL	UNIQUE,
	`role_description`	VARCHAR(255)	NULL,
	PRIMARY KEY (`role_id`)
);

CREATE TABLE `posts` (
	`post_id`	BIGINT	AUTO_INCREMENT,
	`user_id`	BIGINT	NOT NULL,
	`post_title`	VARCHAR(255)	NOT NULL,
	`post_content`	TEXT	NULL,
	`post_date`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`post_id`)
);

CREATE TABLE `comments` (
	`comment_id`	BIGINT	AUTO_INCREMENT,
	`post_id`	BIGINT	NOT NULL,
	`user_id`	BIGINT	NOT NULL,
	`comment_content`	TEXT	NOT NULL,	
	`comment_date`	TIMESTAMP	NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`comment_id`)	
);

# 초기 값 입력

INSERT INTO `role` (`role_name`, `role_description`)
VALUES
('admin', '게시판 관리자입니다.'),
('user', '일반 사용자입니다.');


INSERT INTO `users` (`role_id`, `user_name`, `user_mail`, `user_password`)
VALUES
(1, '관리자', 'admin@admin.com', '1234'),
(2, '홍길동', 'kdhong@test.com', '1234');

INSERT INTO `posts` (`user_id`, `post_title`, `post_content`)
VALUES
(1, '안녕하세요. 관리자입니다.', '화이팅'),
(2, '반갑습니다. 홍길동 백', '반갑습니다');

INSERT INTO `comments` (`post_id`, `user_id`, `comment_content`)
VALUES
(1, 1, '댓글 테스트'),
(1, 2, '홍길동 댓글입니다.'),
(2, 1, '^^'),
(2, 2, '반가워요');