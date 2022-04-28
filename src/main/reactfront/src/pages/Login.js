import React, { useState } from "react";
import { Form, Button } from "react-bootstrap";
import axios from "axios";
import qs from "querystring";

function Login() {
  const querystring = require("querystring");

  const [loginData, setLoginData] = useState({
    username: "",
    password: "",
  });

  const onChange = (e) => {
    const { value, name } = e.target; // e.target에서 name, value 추출
    setLoginData({
      ...loginData, // loginData 복사
      [name]: value,
    });
  };

  const submitHandler = (e) => {
    e.preventDefault();
    console.log(loginData);

    // axios
    //   .post("http://localhost:8080/auth/login", {
    //     username: loginData.username,
    //     password: loginData.password,
    //   }, {headers: {"content-Type" : "application/x-www-form-urlencoded"}})
    //   .then((res) => {
    //     console.log(res);
    //   });

    fetch("http://localhost:8080/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
      },
      body: querystring.stringify({
        username: "sosow0212",
        password: "sosow0212",
      }),
    })
      .then((response) => response.json())
      .then((responseData) => {
        alert(JSON.stringify(responseData));
      });
  };

  return (
    <div className="mt-5">
      <h1>로그인</h1>
      <hr className="mb-5" />
      <Form action="http://localhost:8080/auth/login" method="post" >
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
          type="text"
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
          // onClick={submitHandler}
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
