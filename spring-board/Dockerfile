# JDK 17을 기반 이미지로 사용
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 먼저 해놓으면 도커 레이어 쌓임 Gradle Wrapper, Dependencies 먼저 복사
COPY gradlew gradle ./
COPY build.gradle settings.gradle ./

# 의존성 미리 다운로드 (캐시 활용)
RUN ./gradlew dependencies --no-daemon || true

# 프로젝트 전체 복사 (코드 변경만 있을 때 빌드 캐시 활용)
COPY . .

# Gradle 빌드 실행 (테스트 제외)
RUN ./gradlew clean build -x test

# 스프링부트 실행
ENTRYPOINT ["java", "-jar", "build/libs/spring-board-0.0.1-SNAPSHOT.jar"]
