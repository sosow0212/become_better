import React, { useState } from "react";
import { Form, Button } from "react-bootstrap";
import axios from "axios";

function Register() {
  const [userData, setUserData] = useState({
    username: "",
    password: "",
    name: "",
    email: "",
  });

  const onChange = (e) => {
    const { value, name } = e.target;
    setUserData({
      ...userData, // 기존 userData 객체를 복사
      [name]: value, // name 키를 가진 값을 value로 설정
    });
  };

  const submitHandler = (e) => {
    e.preventDefault();
    console.log(userData);

    axios
      .post("http://localhost:8080/auth/register", {
        username: userData.username,
        password: userData.password,
        name: userData.name,
        email: userData.email,
      })
      .then((res) => {
        console.log(res);
      });
  };

  return (
    <div className="mt-5">
      <h1>회원가입</h1>
      <hr className="mb-5" />

      <Form>
        <Form.Group className="mb-3">
          <Form.Label>아이디</Form.Label>
          <Form.Control
            onChange={onChange}
            type="text"
            placeholder="아이디를 입력해주세요."
            id="username"
            name="username"
          />
        </Form.Group>

        <Form.Group className="mb-3">
          <Form.Label>패스워드</Form.Label>
          <Form.Control
            onChange={onChange}
            type="password"
            placeholder="패스워드를 입력해주세요."
            id="password"
            name="password"
          />
          <Form.Text className="text-muted">
            패스워드는 안전하게 보관됩니다!
          </Form.Text>
        </Form.Group>

        <Form.Group className="mb-3">
          <Form.Label>이름</Form.Label>
          <Form.Control
            onChange={onChange}
            type="text"
            placeholder="이름을 입력해주세요."
            id="name"
            name="name"
          />
        </Form.Group>

        <Form.Group className="mb-3">
          <Form.Label>이메일</Form.Label>
          <Form.Control
            onChange={onChange}
            type="email"
            placeholder="이메일을 입력해주세요."
            id="email"
            name="email"
          />
          <Form.Check
            type="checkbox"
            label="체크하시면, 메일로 유용한 정보가 발송됩니다."
          />
        </Form.Group>

        <Button variant="primary" type="submit" onClick={submitHandler}>
          Submit
        </Button>
      </Form>
    </div>
  );
}

export default Register;
