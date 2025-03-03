const server = "http://127.0.0.1:8080";

// 글 수정 요청 실제
async function fetchEditPost(postId) {
  const formData = {
    postId: postId,
    userId: null,
    postTitle: document.getElementById("postTitle").value,
    postContent: document.getElementById("postContent").value,
  };

  try {
    const response = await fetch(`${server}/posts/${postId}/edit`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    });
    console.log(response);
    if (!response.ok) {
      // 서버에서 받은 오류 메시지 처리
      alert("글 수정 실패! 다시 시도하세요.");
      return;
    }
    alert("글 수정 성공!");
    window.location.href = `${server}/posts`;
  } catch (error) {
    console.error("Error:", error);
    alert("서버 오류 발생!");
  }
}

// 글 수정 요청(폼)
async function fetchEditPostForm(postId) {
  // 로그인 된 사람만
  if (!sessionStorage.getItem("login")) {
    alert("로그인 유저만 수정할 수 있습니다.");
    return;
  }
  try {
    const response = await fetch(`${server}/posts/${postId}/edit/check`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });
    if (!response.ok) {
      // 서버에서 받은 오류 메시지 처리
      alert("글 수정 불가! 다시 시도하세요.");
      return;
    }

    // 글 수정 가능하면 다시 경로로
    location.href = `${server}/posts/${postId}/edit`;
  } catch (error) {
    console.error("Error:", error);
    alert("서버 오류 발생!");
  }
}

// 댓글 삭제 - 댓글 삭제하고 해당 글로 복귀
async function fetchDeleteComment(postId, commentId) {
  if (!sessionStorage.getItem("login")) {
    alert("로그인 유저만 댓글을 삭제할 수 있습니다.");
    return;
  }

  const formData = {
    postId: postId,
    commentId: commentId,
  };

  try {
    const response = await fetch(`${server}/comments/${commentId}/delete`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    });
    console.log(response);
    if (!response.ok) {
      // 서버에서 받은 오류 메시지 처리
      alert("댓글 삭제 실패! 다시 시도하세요.");
      return;
    }
    alert("댓글 삭제 성공!");
    window.location.href = `${server}/posts/${postId}`;
  } catch (error) {
    console.error("Error:", error);
    alert("서버 오류 발생!");
  }
}

// 댓글 쓰기
async function fetchAddComment(postId) {
  if (!sessionStorage.getItem("login")) {
    alert("로그인 유저만 댓글을 쓸 수 있습니다.");
    return;
  }

  const formData = {
    userId: null,
    postId: postId,
    // 앞 뒤 트림하고, 빈값이면 거부하기
    commentContent: document.getElementById("commentContent").value.trim(),
  };
  if (!formData.commentContent) {
    alert("댓글을 입력하세요.");
    return;
  }

  try {
    const response = await fetch(`${server}/comments/add`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    });
    console.log(response);
    if (!response.ok) {
      // 서버에서 받은 오류 메시지 처리
      alert("댓글 등록 실패! 다시 시도하세요.");
      return;
    }
    alert("댓글쓰기 성공!");
    window.location.href = `${server}/posts/${postId}`;
  } catch (error) {
    console.error("Error:", error);
    alert("서버 오류 발생!");
  }
}

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
