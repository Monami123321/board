# Spring Boot 활용 게시판 프로젝트

## 사용 기술

| 이름 | 버전 |
| --- | --- |
| Java | 17 (Zulu) |
| Spring Boot | 3.4.3 (Gradle) |
| Spring Security | 6.xx |
| MariaDB | 11.xx |

## 기능
- 회원가입
- 로그인
- 게시물 전체 목록
- 게시물 상세 조회
- 게시물 수정
- 게시물 삭제
- 댓글 달기
- 댓글 삭제

## 실행
### Linux (docker 필요)
```
# 프로젝트 클론
git clone https://github.com/Monami123321/board.git

# 경로 이동
cd board/docker

# 실행(권한 없으면 sudo)
docker compose up -d
```

### Windows
```
1. 프로젝트 클론
2. mariaDB 실행, init.sql 실행
3. spring boot 설정파일 개발 환경에 맞게 설정
4. IDE에서 실행하거나 gradlew.bat을 통해 빌드 후 실행
```

### 기본값
```
<mariaDB>
port 3306, 유저: root/1234, hy/1234, init.sql 실행

<Spring Boot>
port 8080

<init.sql>
# 이미 회원가입 되어있음, 관리자 추가 가입 불가
1. admin@admin.com / 1234 (관리자)
2. kdhong@test.com / 1234 (홍길동)
```
