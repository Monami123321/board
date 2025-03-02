const server = "http://127.0.0.1:8080";

// 글 삭제
async function fetchDeletePost(postId) {
  try {
    const response = await fetch(`${server}/posts/${postId}/delete`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    });
    console.log(response);
    if (!response.ok) {
      // 서버에서 받은 오류 메시지 처리
      alert("글 삭제 실패! 다시 시도하세요.");
      return;
    }
    alert("글 삭제 성공!");
    window.location.href = `${server}/posts`;
  } catch (error) {
    console.error("Error:", error);
    alert("서버 오류 발생!");
  }
}

// 새글쓰기
async function fetchNewPost() {
  const formData = {
    userId: null,
    postTitle: document.getElementById("postTitle").value,
    postContent: document.getElementById("postContent").value,
  };
  try {
    const response = await fetch(`${server}/posts/new`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    });
    console.log(response);
    if (!response.ok) {
      // 서버에서 받은 오류 메시지 처리
      alert("글 등록 실패! 다시 시도하세요.");
      return;
    }
    alert("글쓰기 성공!");
    window.location.href = `${server}/posts`;
  } catch (error) {
    console.error("Error:", error);
    alert("서버 오류 발생!");
  }
}
