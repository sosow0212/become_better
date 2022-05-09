import React, { useState } from "react";
import { Form, Button } from "react-bootstrap";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";

function Login() {
  const history = useNavigate();
  const propsParam = useParams();

  const [loginData, setLoginData] = useState({
    username: "",
    password: "",
  });

  const [token, setToken] = useState(null);

  // id, pw 밸류 변경
  const onChange = (e) => {
    const { value, name } = e.target; // e.target에서 name, value 추출
    setLoginData({
      ...loginData, // loginData 복사
      [name]: value,
    });
  };

  // 로그인 버튼 누르면 로그인 후, 토큰 처리
  const submitHandler = (e) => {
    e.preventDefault();
    tokenProcess();
  };


  const tokenProcess = async () => {
    axios
      .post("http://localhost:8080/login", {
        username: loginData.username,
        password: loginData.password,
      })
      .then((res) => {
        if (res.status === 200) {
          setToken(res.data.token);
          console.log(token);
          localStorage.setItem("Authorization", token);
          // history("/boards");
        } else {
          console.log("no");
        }
      });
  }

  return (
    <div className="mt-5">
      <h1>로그인</h1>
      <hr className="mb-5" />
      <Form>
        <Form.Label htmlFor="inputPassword5">User ID</Form.Label>
        <Form.Control
          onChange={onChange}
          type="text"
          id="username"
          name="username"
          aria-describedby="idHelpBlock"
        />
        <Form.Text id="idHelpBlock" muted>
          이곳에 아이디를 입력해주세요.
        </Form.Text>

        <br />
        <br />

        <Form.Label htmlFor="inputPassword5">Password</Form.Label>
        <Form.Control
          onChange={onChange}
          type="password"
          id="password"
          name="password"
          aria-describedby="idHelpBlock"
        />
        <Form.Text id="idHelpBlock" muted>
          패스워드를 입력해주세요.
        </Form.Text>
        <br />

        <Button
          variant="outline-dark"
          type="submit"
          className="mt-3"
          onClick={submitHandler}
        >
          로그인
        </Button>
        <hr />
        <br />
        <p>
          계정이 없으시면, <a href="/register">회원가입</a> 해주세요.
        </p>
      </Form>
    </div>
  );
}

export default Login;
