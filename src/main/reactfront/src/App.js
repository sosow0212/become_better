import React from 'react';
import {Routes, Route} from "react-router-dom";
import Register from './pages/Register';
import Main from './pages/Main'
import Info from './pages/Info';
import Nav from './components/Nav';
import { Container } from 'react-bootstrap';




function App() {
  return (
    <div>
      <Nav/>
      <Container>
        <Routes>
          <Route path="/" element={<Main/>}/>
          <Route path="/info" element={<Info/>}/>
          <Route path="/register" element={<Register/>}/>
        </Routes>
      </Container>
    </div>
    
  );
}

export default App;