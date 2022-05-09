import React from "react";
import { Routes, Route } from "react-router-dom";
import { Container } from "react-bootstrap";
import Register from "./pages/Register.js";
import Main from "./pages/Main";
import Info from "./pages/Info";
import Nav from "./components/Nav";
import Login from "./pages/auth/Login";
import Boards from "./pages/Boards.js";
import Logout from './pages/auth/Logout';

function App() {
  return (
    <div>
      <Nav />
      <Container>
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/info" element={<Info />} />
          <Route path="/boards" element={<Boards/>} />
          <Route path="/login" element={<Login />} />
          <Route path="/logout" element={<Logout />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </Container>
    </div>
  );
}

export default App;
