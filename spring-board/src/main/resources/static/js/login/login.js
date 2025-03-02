const server = "http://127.0.0.1:8080";

function validateForm(userLoginRequest) {
  let userMail = userLoginRequest.userMail;
  let userPassword = userLoginRequest.userPassword;

  // 이메일: 이메일 형식 확인
  const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  if (!emailPattern.test(userMail)) {
    alert("이메일 형식이 올바르지 않습니다.");
    return false;
  }

  // 비밀번호: 4자 이상 255자 이하
  if (userPassword.length < 4 || userPassword.length > 255) {
    alert("비밀번호는 4자 이상 255자 이하로 입력해야 합니다.");
    return false;
  }

  // 모든 유효성 검사 통과 시 true 반환
  return true;
}

async function fetchLogin() {
  const formData = {
    userMail: document.getElementById("userMail").value,
    userPassword: document.getElementById("userPassword").value,
  };
  if (!validateForm(formData)) {
    return;
  }

  try {
    const response = await fetch(`${server}/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    });
    console.log(response);
    if (!response.ok) {
      // 서버에서 받은 오류 메시지 처리
      alert("로그인 실패! 다시 시도하세요.");
      return;
    }
    sessionStorage.setItem("login","true");
    alert("로그인 성공!");
    window.location.href = `${server}`;
  } catch (error) {
    console.error("Error:", error);
    alert("서버 오류 발생!");
  }
}
