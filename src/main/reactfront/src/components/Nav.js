import React from "react";
import {
  Button,
  Container,
  Form,
  FormControl,
  Nav,
  Navbar,
} from "react-bootstrap";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <Navbar bg="dark" variant="dark" expand="lg">
      <Container fluid>
        <Navbar.Brand href="/">Become better</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav
            className="me-auto my-2 my-lg-0"
            style={{ maxHeight: "100px" }}
            navbarScroll
          >
            <Link to="/" className="navbar-brand">
              홈
            </Link>
            <Link to="/login" className="navbar-brand">
              로그인
            </Link>
            <Link to="/logout" className="navbar-brand">
              로그아웃
            </Link>
            <Link to="/boards" className="navbar-brand">
              게시판
            </Link>
            <Link to="/info" className="navbar-brand">
              내 정보
            </Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default Header;
